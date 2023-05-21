package IO;

import Plugin.Application.Model.Genre;
import Plugin.IO.Input;
import Plugin.IO.InvalidOptionException;
import Plugin.IO.Output;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.EnumSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class TestInput {


    public static List<Arguments> genreTest() {
        return List.of(
                Arguments.of("0",EnumSet.of(Genre.CLASSIC),null),
                Arguments.of("0123", EnumSet.of(Genre.CLASSIC,
                        Genre.THRILLER,
                        Genre.ROMANCE,
                        Genre.FANTASY),null),
                Arguments.of("asd",null, NoSuchElementException.class),
                Arguments.of("11",EnumSet.of(Genre.THRILLER), null),
                Arguments.of("-1",null, NoSuchElementException.class)
        );
    }

    @ParameterizedTest
    @MethodSource("genreTest")
    public void testGenreSelection(String input, EnumSet<Genre> expected,Class<? extends Throwable> expectedException) {
        Input.userInput = new Scanner(input + Output.lineBreak);
        if(expectedException != null){
            Assertions.assertThrowsExactly(expectedException, Input::promptUserForGenres);
            return;
        }
        Assertions.assertEquals(expected,Input.promptUserForGenres());
    }
}
