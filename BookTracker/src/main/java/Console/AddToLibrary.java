package Console;

import data.Library;
import data.Book;

public class AddToLibrary implements IConsoleCommand {
    Library lib;
    Book bookToAdd;

    public AddToLibrary(Library lib, Book bookToAdd) {
        this.lib = lib;
        this.bookToAdd = bookToAdd;
    }

    @Override
    public String execute() {
        lib.addBook(bookToAdd);
        return "Success";
    }
}
