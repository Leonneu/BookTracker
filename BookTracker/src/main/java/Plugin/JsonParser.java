package Plugin;

import Plugin.Application.Model.Book;
import Plugin.Application.Model.Language;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;

public class JsonParser {
    public static ArrayList<Book> parseHttpResponseToBooks(String response){
        String[] extractedResponses = extractResponses(response);
        ArrayList<Book> result = new ArrayList<>();
        for (String item:extractedResponses
             ) {
            try {
                result.add(parseIntoBook((item)));
            }catch (Exception e){
                continue;
            }
        }
        return result;
    }

    private static Book parseIntoBook(String item) throws MissingFormatArgumentException {
        int titleStartIndex = item.indexOf("\"title\": \"") + 10;
        int titleEndIndex = item.indexOf("\",", titleStartIndex);
        String title = item.substring(titleStartIndex, titleEndIndex);

        int authorStartIndex = item.indexOf("\"authors\": [") + 13;
        int authorEndIndex = item.indexOf("]", authorStartIndex);
        String authorString = item.substring(authorStartIndex, authorEndIndex);
        String author = authorString.substring(authorString.indexOf("\"") + 1, authorString.lastIndexOf("\""));

        int langIndex = item.indexOf("\"language\":");
        int pageCountIndex = item.indexOf("\"pageCount\":");

        if(pageCountIndex==-1||langIndex==-1) throw new MissingFormatArgumentException("Page count or Language missing");
        String language = item.substring(langIndex + 12, item.indexOf(",", langIndex)).replaceAll("\"", "");
        String pageCount = item.substring(pageCountIndex + 12, item.indexOf(",", pageCountIndex)).replaceAll("\"", "");


        return new Book(title,author,Integer.parseInt(pageCount.strip()), Language.valueOf(language.toUpperCase()));
    }

    private static String[] extractResponses(String response) {
        response = response.split("\"items\": ")[1];
        var parts = response.split("\"kind\": \"books#volume\",");
        return Arrays.copyOfRange(parts,1,parts.length);
    }
}
