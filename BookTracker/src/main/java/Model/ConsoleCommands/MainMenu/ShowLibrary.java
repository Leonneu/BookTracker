package Model.ConsoleCommands.MainMenu;

import IO.Output;
import Model.Data.Book;
import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.Data.Library;
import Model.State;

public class ShowLibrary implements ConsoleCommand {
    private DIContainer container;
    public ShowLibrary(DIContainer container) {
        this.container = container;
    }

    @Override
    public State execute() {
        Library lib = container.GetLibrary();
        for (Book b:lib.getBooks()
             ) {
            Output.ShowOutput(b.toString());
        }
        return State.MAIN;
    }

    @Override
    public String name() {
        return "Show Books in Library";
    }

    @Override
    public String description() {
        return "Shows all the Books currently in the Library";
    }
}
