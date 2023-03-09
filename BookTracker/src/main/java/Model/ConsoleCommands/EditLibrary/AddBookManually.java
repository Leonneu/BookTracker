package Model.ConsoleCommands.EditLibrary;

import IO.Input;
import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.Book;
import Model.Data.DIContainer;
import Model.Data.Library;
import Model.State;

public class AddBookManually extends ConsoleCommand {
    public AddBookManually(DIContainer container) {
        super(container);
    }
    private Library library;
    @Override
    public State execute() {
        library = container.GetLibrary();//TODO set library dynamically for wishlist?
        Book newBook = Input.GetBook();
        library.addBook(newBook);//TODO Check for duplicates

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
