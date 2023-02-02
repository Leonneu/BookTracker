import Console.AddToLibrary;
import Console.IConsoleCommand;
import data.Book;
import data.Genre;
import data.GoogleBooksWebApi;
import data.Library;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        GoogleBooksWebApi google = new GoogleBooksWebApi();
        String search = s.nextLine();
        try {
            var results = google.searchForBookByTitle(search);
            for (var b:results
                 ) {
                System.out.println(b.toString());
            }
        }catch (Exception e){

        }
        //TODO WRITE UNIT TEST for parser!!
    }
}
