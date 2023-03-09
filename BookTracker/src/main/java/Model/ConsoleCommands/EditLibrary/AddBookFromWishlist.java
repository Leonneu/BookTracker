package Model.ConsoleCommands.EditLibrary;

import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;

public class AddBookFromWishlist extends ConsoleCommand {
    public AddBookFromWishlist(DIContainer container) {
        super(container);
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
