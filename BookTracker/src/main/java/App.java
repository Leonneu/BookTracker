import Console.AddToLibrary;
import Console.IConsoleCommand;
import data.Book;
import data.Genre;
import data.Library;

import java.util.Scanner;

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
        lib.SaveLibrary("output.txt");
        Scanner s = new Scanner(System.in);
        boolean resume = true;
        while (resume) {
            String input = s.nextLine();
            IConsoleCommand cmd = null;
            switch (input) {
                case "a":
                    System.out.println("Was für Buch");
                    cmd = new AddToLibrary(lib,new Book("Test","Author",Genre.FANTASY));
                    break;
                case "b":
                    resume = false;
                default:
            }
            System.out.println(cmd.execute());
        }
    }
}
