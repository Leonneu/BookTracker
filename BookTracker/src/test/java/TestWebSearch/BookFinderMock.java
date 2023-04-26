package TestWebSearch;

import Plugin.Application.BookFinder;
import Plugin.Application.BookNotFoundException;
import Plugin.Application.Model.Book;
import Plugin.Application.Model.Genre;
import Plugin.Application.Model.Language;

import java.util.ArrayList;
import java.util.List;

public class BookFinderMock implements BookFinder {
    @Override
    public ArrayList<Book> searchForBookByTitle(String bookTitle) throws BookNotFoundException {

        return (ArrayList<Book>) List.of(new Book("test","test",0,Language.EN ));
    }
}
