package Plugin.Application.ConsoleCommands.ShowStatistics;

import Plugin.Application.Model.Genre;
import Plugin.Application.Model.ReadingList;

import java.util.Arrays;

public class ReadingListStatisticGenerator {
    ReadingList readingList;
    public ReadingListStatisticGenerator(ReadingList readingList) {
        this.readingList = readingList;
    }

    public int numberOfBooksOnReadingList(){
        return  readingList.getReadingListAsList().size();
    }

    public double percentOfBooksOwned(){
        return readingList.getOwnedBooks().size()/(double)readingList.getReadingListAsList().size();
    }

    public Genre mostPopularGenre(){
        var result = new int[Genre.values().length];
        for (var e:readingList.getReadingListAsList()
        ) {
            for (var g:e.book().Genre()
            ) {
                result[g.ordinal()]++;
            }
        }
        return Genre.values()[Arrays.stream(result).max().getAsInt()];
    }

    public int pagesToRead(){
        return readingList.getReadingListAsList().stream().map(r->r.book().Pagecount()).reduce(0,Integer::sum);
    }

}
