import data.Book;
import data.Genre;
import data.Library;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook(new Book("Test", "TestA", Genre.FANTASY));
        for (Book b : lib.getBooks()
        ) {
            System.out.println(b.toString());
        }
    }
}
