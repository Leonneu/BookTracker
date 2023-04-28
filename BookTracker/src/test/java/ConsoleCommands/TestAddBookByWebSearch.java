package ConsoleCommands;

import Plugin.Application.ConsoleCommands.EditReadingList.AddReadingListEntryByWebSearch;
import Plugin.Application.Container;
import Plugin.Application.Model.ReadingArchive;
import Plugin.Application.Model.ReadingList;
import Plugin.IO.Input;
import Plugin.IO.Output;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class TestAddBookByWebSearch {
    @BeforeAll
    public static void setup() {
        Input.userInput = new Scanner("title" + Output.lineBreak +"1"+Output.lineBreak);
    }
    @Test
    public void ensureBookGetsAdded(){
        Container container = new Container(new ReadingList(new ArrayList<>()),new ReadingArchive(new ArrayList<>()));
        var command = new AddReadingListEntryByWebSearch(container,new BookFinderMock());
        command.execute();
        Assertions.assertEquals(1,container.getReadingList().getReadingListAsList().size());
    }
}
