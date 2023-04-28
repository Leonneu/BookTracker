package Model;

import Plugin.Application.Model.BookDateWrapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class TestBookDateWrapper {
    public static List<Arguments> dates() {
        return List.of(
                Arguments.of(
                        new BookDateWrapper(10, 10, 2023),
                        new BookDateWrapper(11, 10, 2023),
                        2),
                Arguments.of(
                        new BookDateWrapper(10, 10, 202),
                        new BookDateWrapper(11, 10, 202),
                        2),
                Arguments.of(
                        new BookDateWrapper(10, 10, 2023),
                        new BookDateWrapper(11, 10, 2023),
                        2),
                Arguments.of(
                        new BookDateWrapper(14, 2, 2021),
                        new BookDateWrapper(13, 1, 2022),
                        334)
        );
    }

    @ParameterizedTest
    @MethodSource("dates")
    public void testDurationCalculation(BookDateWrapper startDate, BookDateWrapper endDate, int expected) {
        Assertions.assertEquals(expected, startDate.getDifference(endDate));
    }
}
