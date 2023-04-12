package Plugin.Application.ConsoleCommands.EditReadingList;

import Plugin.Application.Container;
import Plugin.Application.Model.Genre;
import Plugin.Application.Model.ReadingListEntry;
import Plugin.IO.Input;
import Plugin.IO.Output;
import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Application.Model.*;
import Plugin.Application.State;
import Plugin.Application.Model.Book;
import Plugin.Application.Model.Language;

import java.util.EnumSet;

public class AddReadingListEntryManually implements ConsoleCommand {
    private Container container;
    public AddReadingListEntryManually(Container container) {
     this.container = container;
    }
    @Override
    public State execute() {
        try {
            String title = Input.promptMsg("Titel:");
            String author = Input.promptMsg("Autor:");
            int pageCount = Integer.parseInt(Input.promptMsg("Seitenzahl:"));
            Language language = Language.valueOf(Input.promptMsg("Sprache (EN/DE):"));
            EnumSet<Genre> genres = Input.promptUserForGenres();
            container.getReadingList().addReadingListEntry(new ReadingListEntry(new Book(title,author,pageCount,language,genres)));
        }catch (Exception e){
            Output.showOutput(e.getMessage());
        }
        return State.MAIN;
    }

    @Override
    public String name() {
        return "Manually";
    }

    @Override
    public String description() {
        return null;
    }
}
