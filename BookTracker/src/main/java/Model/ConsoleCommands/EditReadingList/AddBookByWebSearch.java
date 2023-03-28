package Model.ConsoleCommands.EditReadingList;

import IO.Output;
import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.*;
import Model.GoogleBooksWebApi;
import Model.State;
import IO.Input;

import java.util.ArrayList;
import java.util.EnumSet;

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
        }//TODO Refactor A lot
        Output.ShowOutput("Welches der folgenden Bücher?");
        Output.ShowOutput(Output.ParseBooksIntoOutput(results));
        int selectedOption=0;
        try {
          selectedOption = Input.GetOption(results.size());
        }catch (Exception e){
            //TODO Errorhandeling;
        }
        EnumSet<Genre> genres = Input.promptUserForGenres();
        Book bNew = new Book(results.get(selectedOption),genres);
        container.GetReadingList().AddReadingListEntry(new ReadingListEntry(bNew,false,"Testing"));
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
