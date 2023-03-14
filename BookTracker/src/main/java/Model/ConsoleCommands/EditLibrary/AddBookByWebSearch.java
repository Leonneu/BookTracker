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

public class AddBookByWebSearch implements ConsoleCommand {
    private DIContainer container;
    public AddBookByWebSearch(DIContainer container){
        this.container = container;
    }

    @Override
    public State execute() {
        String searchPrompt = Input.promptMsg("Titel für die Suche Eingeben");
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
