package Plugin;

import Plugin.Application.Model.Book;

import java.util.ArrayList;

public interface BookParser {
    public ArrayList<Book> parseHttpResponseToBooks(String jsonString);
}
