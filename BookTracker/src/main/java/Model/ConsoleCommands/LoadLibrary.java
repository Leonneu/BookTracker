package Model.ConsoleCommands;

import IO.Input;
import IO.Output;
import Model.*;
import Model.Data.Book;
import Model.Data.DIContainer;
import Model.Data.Genre;
import Model.Data.Library;

import java.util.ArrayList;
import java.util.EnumSet;

public class LoadLibrary implements ConsoleCommand {
    private DIContainer container;

    public LoadLibrary(DIContainer container) {
        this.container = container;
    }

    @Override
    public State execute() {
        Output.ShowOutput("Enter File path");
        String path = Input.GetLibraryFilePath();
        ArrayList<String> text = Input.LoadTextFile(Input.parseFilePath(path));
        Library lib = new Library(StringArrayToBooksArray(text));
        container.SetLibrary(lib);
        return State.MAIN;
    }

    private ArrayList<Book> StringArrayToBooksArray(ArrayList<String> booksAsString) {
        ArrayList<Book> result = new ArrayList<>();
        for (String str : booksAsString
        ) {
            var values = str.split("\\|");
            Book b = new Book(values[0], values[1], EnumSet.of(Genre.valueOf(values[2])));
            result.add(b);
        }
        return result;
    }

    @Override
    public String name() {
        return "Bibliothek laden";
    }

    @Override
    public String description() {
        return "Lade eine Bibliothek Datei. Es muss ein Dateipfad angegeben werden.";
    }
}
