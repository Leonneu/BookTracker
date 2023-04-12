package Plugin.Application;

import Plugin.Application.Model.Book;

import java.util.ArrayList;

public interface BookFinder {
    ArrayList<Book> searchForBookByTitle(String bookTitle) throws BookNotFoundException;
}
