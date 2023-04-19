package Plugin.Application.ConsoleCommands.ShowStatistics;

import Plugin.Application.Container;
import Plugin.Application.Model.*;

public class StatisticsGenerator {
    ReadingList readingList;
    ReadingArchive readingArchive;
    BookDateWrapper month;

    public StatisticsGenerator(Container container) {
        this.readingArchive = container.getReadingArchive();
        this.readingList = container.getReadingList();
        this.month = new BookDateWrapper();
    }

    public StatisticsGenerator(Container container, BookDateWrapper month) {
        this.month = month;
    }

    public int pagesReadThisMonth() {
        return readingArchive.getArchiveAsList().stream()
                .filter(e -> (e.startedReading().month() == month.month() && e.finishedReading().month() == month.month()))
                .map(ReadingArchiveEntry::book)
                .map(Book::Pagecount)
                .reduce(0, Integer::sum);
    }



}
