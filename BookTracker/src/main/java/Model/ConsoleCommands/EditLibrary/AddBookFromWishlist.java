package Model.ConsoleCommands.EditLibrary;

import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;

public class AddBookFromWishlist implements ConsoleCommand {
    private DIContainer container;
    public AddBookFromWishlist(DIContainer container){
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
