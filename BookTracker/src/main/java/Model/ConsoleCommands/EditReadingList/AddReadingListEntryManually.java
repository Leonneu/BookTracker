package Model.ConsoleCommands.EditReadingList;

import IO.Input;
import IO.Output;
import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.*;
import Model.State;

import java.util.EnumSet;

public class AddReadingListEntryManually implements ConsoleCommand {
    private DIContainer container;
    public AddReadingListEntryManually(DIContainer container) {
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
            container.GetReadingList().AddReadingListEntry(new ReadingListEntry(new Book(title,author,pageCount,language,genres)));
        }catch (Exception e){
            Output.ShowOutput(e.getMessage());
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
