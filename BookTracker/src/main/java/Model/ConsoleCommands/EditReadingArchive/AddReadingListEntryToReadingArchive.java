package Model.ConsoleCommands.EditReadingArchive;

import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;

public class AddReadingListEntryToReadingArchive implements ConsoleCommand {
    private DIContainer container;
    public AddReadingListEntryToReadingArchive(DIContainer container){
        this.container=container;
    }

    @Override
    public State execute() {
        return null;
    }

    @Override
    public String name() {
        return "From Wishlist";
    }

    @Override
    public String description() {
        return null;
    }
}
