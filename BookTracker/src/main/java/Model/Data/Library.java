package Model.Data;

import Model.Data.Book;

import java.io.*;
import java.util.ArrayList;

public class Library {

    final ArrayList<Book> books;

    public Library(ArrayList<Book> lib) {
        books = lib;
    }

    public void addBook(Book book){
        books.add(book);
    }
    public ArrayList<Book> getBooks(){
        return books;
    }
    public void saveLibrary(String path){
        File file = new File(path);
        try (PrintWriter out = new PrintWriter(file)) {
            for (Book b: books
                 ) {
                out.println(b.toString());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
