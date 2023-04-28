package StatisticsGeneratorTest;

import Plugin.Application.ConsoleCommands.ShowStatistics.ReadingArchiveStatisticGenerator;
import Plugin.Application.ConsoleCommands.ShowStatistics.TypeOfReport;
import Plugin.Application.Model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class TestReadingArchiveGenerator {
    static ReadingArchive testArchive;
    static Random rnd = new Random(1);

    @BeforeEach
    public void setup(){
        testArchive = new ReadingArchive(new ArrayList<>());
        for (int i = 0; i < 100; i++) {
            testArchive.AddEntry(generateEntry());
        }
    }
    public static ReadingArchiveEntry generateEntry(){
        return new ReadingArchiveEntry(
                new Book("title","author",rnd.nextInt(1001),Language.EN),
                generateDate(2021),
                generateDate(2022),
                "");
    }

    public static BookDateWrapper generateDate(int year){
        return new BookDateWrapper(rnd.nextInt(28)+1,rnd.nextInt(12)+1,year);
    }

    @Test
    public void testFastestRead() {
        ReadingArchiveEntry expected = new ReadingArchiveEntry(new Book("title","author",100000,Language.EN),
                new BookDateWrapper(10,10,2023),
                new BookDateWrapper(11,10,2023),
                "");
        testArchive.AddEntry(expected);
        ReadingArchiveStatisticGenerator generator = new ReadingArchiveStatisticGenerator(testArchive);
        Assertions.assertEquals(expected, generator.fastestRead());
    }

    @Test
    public void testShortestRead() {
        ReadingArchiveEntry expected = new ReadingArchiveEntry(new Book("title","author",100,Language.EN),
                new BookDateWrapper(10,10,2023),
                new BookDateWrapper(10,10,2023),
                "");
        testArchive.AddEntry(expected);
        ReadingArchiveStatisticGenerator generator = new ReadingArchiveStatisticGenerator(testArchive,new BookDateWrapper(), TypeOfReport.TOTAL);
        Assertions.assertEquals(expected, generator.shortestRead());
    }


}
