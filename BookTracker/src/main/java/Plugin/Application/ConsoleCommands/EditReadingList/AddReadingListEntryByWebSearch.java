package Plugin.Application.ConsoleCommands.EditReadingList;

import Plugin.Application.BookFinder;
import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.Model.Book;
import Plugin.Application.Model.Genre;
import Plugin.Application.Model.ReadingListEntry;
import Plugin.Application.State;
import Plugin.IO.Input;
import Plugin.IO.Output;

import java.util.ArrayList;
import java.util.EnumSet;

public class AddReadingListEntryByWebSearch implements ConsoleCommand {
    private final Container container;
    private final BookFinder bookFinder;
    public AddReadingListEntryByWebSearch(Container container,BookFinder bookFinder){
        this.bookFinder =bookFinder;
        this.container = container;
    }

    @Override
    public State execute() {
        String searchPrompt = Input.promptMsg("Titel für die Suche Eingeben");
        ArrayList<Book> results;
        try {
            results = bookFinder.searchForBookByTitle(searchPrompt);
        } catch (Exception e){
            Output.showOutput(e.getMessage());
            return State.MAIN;
        }
        Book e = Input.promptUserForListChoice(results);
        EnumSet<Genre> genres = Input.promptUserForGenres();
        container.getReadingList().addReadingListEntry(new ReadingListEntry(new Book(e,genres),false,"-"));
        return State.MAIN;
    }

    @Override
    public String name() {
        return "Durch Web-Suche";
    }

    @Override
    public String description() {
        return "Füge ein Buch durch eine Suche in der Google Books API hinzu";
    }
}
