package Plugin.IO;

import Plugin.Application.ConsoleCommands.ConsoleCommand;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Output {
    public static String lineBreak = System.lineSeparator();

    public static void showOutput(String message) {
        System.out.println(message);
    }

    public static String parseOptions(List<String> options){
        int n = options.size();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(i).append(". ").append(options.get(i)).append(lineBreak);
        }
        return result.toString();
    }

    public static String parseGenreOptions(String[] options) {
        int n = options.length;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(i).append(". ").append(options[i]).append(lineBreak);
        }
        return result.toString();
    }


    public static void saveToTextFile(String content, File path) {
        try (PrintWriter out = new PrintWriter(path)) {
            out.print(content);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveToNewTextFile(String path, String output) {
        try{
            File f = new File(path + "\\Wunschliste.txt");
            f.createNewFile();
            saveToTextFile(output,f);
            Output.showOutput("Datei erfolgreich gespeichert!");
        }catch (Exception e){
            Output.showOutput(e.getMessage());
        }

    }
}
