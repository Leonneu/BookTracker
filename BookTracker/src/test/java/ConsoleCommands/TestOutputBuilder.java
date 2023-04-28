package ConsoleCommands;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.ConsoleCommands.ShowReadingArchive.ShowReadingArchiveByAuthor;
import Plugin.Application.ConsoleCommands.ShowReadingArchive.ShowReadingArchiveByTitle;
import Plugin.Application.ConsoleCommands.ShowReadingList.ShowOwnedBooks;
import Plugin.Application.ConsoleCommands.ShowReadingList.ShowReadingListByAuthor;
import Plugin.Application.ConsoleCommands.ShowReadingList.ShowReadingListByTitle;
import Plugin.Application.ConsoleCommands.ShowReadingList.ShowUnownedBooks;
import Plugin.Application.Container;
import Plugin.Application.Model.ReadingArchive;
import Plugin.Application.Model.ReadingList;
import Plugin.IO.Input;
import Plugin.IO.Output;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestOutputBuilder {
    public static List<Arguments> classesToTest() {
        Container container = new Container(new ReadingList(new ArrayList<>()), new ReadingArchive(new ArrayList<>()));
        OutputBuilderMock mock = new OutputBuilderMock();
        return List.of(
                Arguments.of(new ShowOwnedBooks(container, mock), mock),
                Arguments.of(new ShowReadingListByAuthor(container, mock), mock),
                Arguments.of(new ShowReadingListByTitle(container, mock), mock),
                Arguments.of(new ShowUnownedBooks(container, mock), mock),
                Arguments.of(new ShowReadingArchiveByAuthor(container, mock), mock),
                Arguments.of(new ShowReadingArchiveByTitle(container, mock), mock)
        );
    }

    @BeforeEach
    public void resetInput() {
        Input.userInput = new Scanner(" " + Output.lineBreak);
    }

    @ParameterizedTest
    @MethodSource("classesToTest")
    public void testOutputBuilderGetsUsedProperly(ConsoleCommand cmd, OutputBuilderMock mock) {
        mock.resetMock();
        cmd.execute();
        Assertions.assertTrue(mock.resetWasCalled);
        Assertions.assertTrue(mock.finaliseWasCalled);
    }
}
