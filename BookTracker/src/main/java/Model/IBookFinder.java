package Model;

import java.util.ArrayList;

public interface IBookFinder {
    ArrayList<Book> searchForBookByTitle(String bookTitle) throws BookNotFoundException;
}
