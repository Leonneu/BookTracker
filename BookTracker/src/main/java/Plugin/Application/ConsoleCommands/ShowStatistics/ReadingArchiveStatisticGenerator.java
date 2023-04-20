package Plugin.Application.ConsoleCommands.ShowStatistics;

import Plugin.Application.Model.*;

import java.util.Arrays;
import java.util.List;

public class ReadingArchiveStatisticGenerator {
    private final ReadingArchive readingArchive;
    private final BookDateWrapper targetDate;
    private final List<ReadingArchiveEntry> readInTargetTimeSpan;

    public ReadingArchiveStatisticGenerator(ReadingArchive archive) {
        this.readingArchive = archive;
        this.targetDate = new BookDateWrapper();
        this.readInTargetTimeSpan = readingArchive.searchByYear(targetDate.year());
    }

    public ReadingArchiveStatisticGenerator(ReadingArchive archive, BookDateWrapper targetDate,TypeOfReport type) {
        this.readingArchive = archive;
        this.targetDate = targetDate;
        switch (type){
            case YEAR -> this.readInTargetTimeSpan = readingArchive.searchByYear(this.targetDate.year());
            case MONTH -> this.readInTargetTimeSpan = readingArchive.searchByMonth(this.targetDate);
            default -> this.readInTargetTimeSpan = readingArchive.getArchiveAsList();
        }
    }

    public int countPages(List<Book> books){
        return books.stream().map(Book::Pagecount).reduce(0,Integer::sum);
    }
    public int pagesReadInTimeSpan(){
        return countPages(readInTargetTimeSpan.stream().map(ReadingArchiveEntry::book).toList());
    }
    public double avgPagesInTimeSpan(){
        return countPages(readInTargetTimeSpan.stream().map(ReadingArchiveEntry::book).toList())/(double) booksReadInTimeSpan();
    }
    public int booksReadInTimeSpan(){
        return readInTargetTimeSpan.size();
    }
    public Genre mostPopularGenre(){
        var result = new int[Genre.values().length];
        for (var e:readInTargetTimeSpan
             ) {
            for (var g:e.book().Genre()
                 ) {
                result[g.ordinal()]++;
            }
        }
        return Genre.values()[Arrays.stream(result).max().getAsInt()];
    }

    public ReadingArchiveEntry fastestRead(){
        return readInTargetTimeSpan.stream().reduce((a, b)->
                a.book().Pagecount()/a.getReadingDuration() > b.book().Pagecount()/b.getReadingDuration() ? a:b
        ).get();
    }

    public ReadingArchiveEntry shortestRead(){
        return readInTargetTimeSpan.stream().reduce((a,b)->a.getReadingDuration()>b.getReadingDuration()?a:b).get();
    }
}
