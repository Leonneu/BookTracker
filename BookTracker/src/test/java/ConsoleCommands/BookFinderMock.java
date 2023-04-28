package ConsoleCommands;

import Plugin.Application.BookFinder;
import Plugin.Application.BookNotFoundException;
import Plugin.Application.Model.Book;
import Plugin.Application.Model.Language;

import java.util.ArrayList;

public class BookFinderMock implements BookFinder {
    @Override
    public ArrayList<Book> searchForBookByTitle(String bookTitle) throws BookNotFoundException {
        var result = new ArrayList<Book>();
        result.add(new Book("title","title",1,Language.EN));
        return result;
    }
}
