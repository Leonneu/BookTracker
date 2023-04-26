package StatisticsGeneratorTest;

import Plugin.Application.ConsoleCommands.ShowStatistics.ReadingListStatisticGenerator;
import Plugin.Application.Model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestReadingListGenerator {
    public static List<Arguments> testReadingList() {
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

    @ParameterizedTest
    @MethodSource("testReadingList")
    public void testPercentOfBooksOwned(ReadingList readingList, double expected, double delta) {
        ReadingListStatisticGenerator generator = new ReadingListStatisticGenerator(readingList);
        Assertions.assertEquals(expected, generator.percentOfBooksOwned(), delta);
    }
}
