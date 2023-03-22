package Model.ConsoleCommands.MainMenu;

import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;

public class AddBookFromReadingList implements ConsoleCommand {
    private DIContainer container;
    public AddBookFromReadingList(DIContainer container){
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
