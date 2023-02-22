import Console.AddToLibrary;
import Console.IConsoleCommand;
import data.Book;
import data.Genre;
import data.GoogleBooksWebApi;
import data.Library;

import java.io.File;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean stop = false;
        System.out.println("Please select a Library to load:");
        String path = s.nextLine();
        Library lib = new Library("BookTracker\\input.txt");

        while (!stop){
            System.out.println("What would you like to do:");
            System.out.println("1. Add Book");
            System.out.println("2. Show Books");
            System.out.println("3. Save and Quit");
            String input = s.nextLine();

            switch (Integer.parseInt(input)){
                case 1:
                    System.out.println("Options:");
                    System.out.println("1. WebSearch");
                    System.out.println("2. Custom");
                    Book bookToAdd = null;
                    String option = s.nextLine();
                    switch(Integer.parseInt(option)){
                        case 1:
                            //Do something
                            break;
                        case 2:
                            System.out.println("Title:");
                            String title = s.nextLine();
                            System.out.println("Author:");
                            String author = s.nextLine();
                            for (var v:Genre.values()
                                 ) {
                                System.out.print(","+v.name());
                            }
                            System.out.println(" Genre:");
                            Genre g = Genre.valueOf(s.nextLine().toUpperCase());
                            bookToAdd = new Book(title,author,g);

                    }
                    if(bookToAdd!=null) lib.addBook(bookToAdd);
                    break;
                case 2:
                    for (Book b: lib.getBooks()
                         ) {
                        System.out.println(b.toString());
                    }
                    break;
                case 3:
                    lib.saveLibrary("output.txt");
                    stop = true;
                    break;
                default:

            }
        }
    }

}
