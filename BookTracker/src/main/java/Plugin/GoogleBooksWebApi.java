package Plugin;

import Plugin.Application.BookNotFoundException;
import Plugin.Application.BookFinder;
import Plugin.Application.Model.Book;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;

public class GoogleBooksWebApi implements BookFinder {
    //TODO Extract Methods
    @Override
    public ArrayList<Book> searchForBookByTitle(String bookTitle) throws BookNotFoundException {
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(20))
                .build();
        //TODO extra Zeile
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.googleapis.com/books/v1/volumes?q=" + bookTitle.replace(" ", "+")))
                .header("accept", "application/json")
                .GET()
                .build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            return new ArrayList<>();
        }
        var resultBookList = JsonParser.parseHttpResponseToBooks(response.body());
        if (resultBookList.size() < 1) throw new BookNotFoundException("Keine Treffer");
        return resultBookList;
    }
}
