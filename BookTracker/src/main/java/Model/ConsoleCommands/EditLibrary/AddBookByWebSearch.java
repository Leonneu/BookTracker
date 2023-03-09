package Model.ConsoleCommands.EditLibrary;

import IO.Output;
import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.Book;
import Model.Data.DIContainer;
import Model.Data.Library;
import Model.GoogleBooksWebApi;
import Model.State;
import IO.Input;

import java.util.ArrayList;

public class AddBookByWebSearch extends ConsoleCommand {
    public AddBookByWebSearch(DIContainer container) {
        super(container);
    }

    @Override
    public State execute() {
        String searchPrompt = Input.GetSearchPrompt();
        GoogleBooksWebApi webSearch = new GoogleBooksWebApi();
        ArrayList<Book> results;
        try {
            results = webSearch.searchForBookByTitle(searchPrompt);
        } catch (Exception e){
            Output.ShowOutput(e.getMessage());
            return State.MAIN;
        }
        container.GetLibrary().addBook(results.get(0));
        return State.MAIN;
    }

    @Override
    public String name() {
        return "By Web-search";
    }

    @Override
    public String description() {
        return null;
    }
}
