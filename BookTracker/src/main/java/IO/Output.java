package IO;

import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.Book;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Output {
    public static String lineBreak = System.lineSeparator();

    public static void ShowOutput(String message) {
        System.out.println(message);
    }

    public static String ParseStateOptions(ConsoleCommand[] options) {
        int n = options.length;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(i).append(". ").append(options[i].name()).append(lineBreak);
        }
        return result.toString();
    }

    public static String ParseGenreOptions(String[] options) {
        int n = options.length;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(i).append(". ").append(options[i]).append(lineBreak);
        }
        return result.toString();
    }

    public static void saveToTextFile(String content) {
        try (PrintWriter out = new PrintWriter("filename.txt")) {
            out.print(content);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String ParseBooksIntoOutput(List<Book> books){
        int n = books.size();
        StringBuilder result = new StringBuilder();
        for (int i=0;i<n;i++){
            result.append(i).append(". ").append(books.get(i).toString()).append(lineBreak);
        }
        return result.toString();
    }
}
