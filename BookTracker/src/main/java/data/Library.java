package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Library {

    ArrayList<Book> Books = new ArrayList<Book>();

    public void addBook(Book book){
        Books.add(book);
    }
    public ArrayList<Book> getBooks(){
        return Books;
    }
    public void SaveLibrary(){
        File file = new File("output.txt");
        try (PrintWriter out = new PrintWriter(file)) {
            out.println(Books.get(0).toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
