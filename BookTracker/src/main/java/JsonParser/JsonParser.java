package JsonParser;

import data.Book;
import data.Genre;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class JsonParser {
    public static final int NUMBEROFRESULTS = 10;

    public static ArrayList<Book> parseHttpResponseToBooks(String response){
        String[] extractedResponses = extractResponses(response);
        ArrayList<Book> result = new ArrayList<>();
        for (String item:extractedResponses
             ) {
            result.add(parseIntoBook(item));
        }
        return result;
    }

    private static Book parseIntoBook(String item) {
        int titleStart = item.indexOf("title: \"");
        int titleEnd = item.indexOf("\",",titleStart);
        String title = item.substring(titleStart+8,titleEnd);//TODO Magic Ints
        int authorStart = item.indexOf("author: \"");
        int authorEnd = item.indexOf("\",",authorStart);
        String author = item.substring(authorStart+9,authorEnd);
        int genreStart = item.indexOf("categories: \"");
        int genreEnd = item.indexOf("\",",genreStart);
        Genre genre = Genre.valueOf(item.substring(genreStart+13,genreEnd).toUpperCase());
        Book book = new Book(title,author,genre);
        return book;
    }

    private static String[] extractResponses(String response) {
        response = response.split("\"items\": ")[1];
        var parts = response.split("\"kind\": \"books#volume\",");
        return parts;
    }
}
