package Model;

import Model.Data.Book;

import java.util.ArrayList;

public interface IBookFinder {
    ArrayList<Book> searchForBookByTitle(String bookTitle) throws BookNotFoundException;
}
