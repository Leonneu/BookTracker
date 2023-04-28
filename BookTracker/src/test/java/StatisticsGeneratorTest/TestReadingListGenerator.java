package StatisticsGeneratorTest;

import Plugin.Application.ConsoleCommands.ShowStatistics.ReadingListStatisticGenerator;
import Plugin.Application.Model.Book;
import Plugin.Application.Model.Language;
import Plugin.Application.Model.ReadingList;
import Plugin.Application.Model.ReadingListEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class TestReadingListGenerator {
    public static List<Arguments> testReadingListOwned() {
        return List.of(
                Arguments.of(new ReadingList(generateArrayList(1, 2)), 0.33, 0.01),
                Arguments.of(new ReadingList(generateArrayList(10, 0)), 1, 0),
                Arguments.of(new ReadingList(generateArrayList(4, 6)), 0.4, 0),
                Arguments.of(new ReadingList(generateArrayList(500, 500)), 0.5, 0),
                Arguments.of(new ReadingList(generateArrayList(0, 0)), Double.NaN, 0),
                Arguments.of(new ReadingList(generateArrayList(0, 20)), 0, 0));
    }

    private static ArrayList<ReadingListEntry> generateArrayList(int numberOfOwned, int numberOfUnowned) {
        ArrayList<ReadingListEntry> result = new ArrayList<>();
        for (int i = 0; i < numberOfOwned; i++) {
            result.add(generateEntry(true));
        }
        for (int i = 0; i < numberOfUnowned; i++) {
            result.add(generateEntry(false));
        }
        return result;
    }

    private static ReadingListEntry generateEntry(boolean isOwned) {
        return new ReadingListEntry(new Book("Testing", "Testing", 1, Language.EN), isOwned, "");
    }

    private static ReadingListEntry generateEntry(Integer pageCount) {
        return new ReadingListEntry(new Book("Testing", "Testing", pageCount, Language.EN), true, "");
    }

    @ParameterizedTest
    @MethodSource("testReadingListOwned")
    public void testPercentOfBooksOwned(ReadingList readingList, double expected, double delta) {
        ReadingListStatisticGenerator generator = new ReadingListStatisticGenerator(readingList);
        Assertions.assertEquals(expected, generator.percentOfBooksOwned(), delta);
    }

    public static List<Arguments> testTotal() {
        return List.of(
                Arguments.of(new ReadingList(generateArrayList(new int[]{10, 10, 10, 10})), 40),
                Arguments.of(new ReadingList(generateArrayList(new int[]{100, 10, 10, 10})), 130),
                Arguments.of(new ReadingList(generateArrayList(new int[]{100000, 10000, 1000, 100,10,1})), 111111),
                Arguments.of(new ReadingList(generateArrayList(new int[]{1})), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testTotal")
    public void testTotalPages(ReadingList readingList,int expected){
        ReadingListStatisticGenerator generator = new ReadingListStatisticGenerator(readingList);
        Assertions.assertEquals(expected, generator.pagesToRead());
    }

    public static List<Arguments> testAvg() {
        return List.of(
                Arguments.of(new ReadingList(generateArrayList(new int[]{10, 10, 10, 10})), 10),
                Arguments.of(new ReadingList(generateArrayList(new int[]{20, 5, 100, 1})), 31.5),
                Arguments.of(new ReadingList(generateArrayList(new int[]{1})), 1),
                Arguments.of(new ReadingList(generateArrayList(new int[]{12, 13, 14, 15})), 13.5)
        );
    }

    @ParameterizedTest
    @MethodSource("testAvg")
    public void testAvgPageCalculation(ReadingList readingList, double expected) {
        ReadingListStatisticGenerator generator = new ReadingListStatisticGenerator(readingList);
        Assertions.assertEquals(expected, generator.avgPageCount());
    }

    public static ArrayList<ReadingListEntry> generateArrayList(int[] pages) {
        ArrayList<ReadingListEntry> result = new ArrayList<>();
        for (Integer page : pages) {
            result.add(generateEntry(page));
        }
        return result;
    }
}
