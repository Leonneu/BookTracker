package IO;

import Model.Data.Book;
import Model.Data.Genre;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    private static Scanner userInput = new Scanner(System.in);
    private static Pattern filePathpattern = Pattern.compile("\\\\(?:\\w+\\\\)*\\w+\\.\\w+$");

    public static int GetOption(int numberOfValidOptions) throws InvalidOptionException {
        int selectedOption = Integer.parseInt(userInput.nextLine());
        userInput.reset();
        if (0 <= selectedOption && selectedOption < numberOfValidOptions)
            return selectedOption;
        throw new InvalidOptionException("Invalid Option");
    }

    public static boolean validateFilePath(String path){
        Matcher matchPath = filePathpattern.matcher(path);
        return matchPath.matches();
    }

    public static File parseFilePath(String path) throws InvalidPathException {
        File f = new File(System.getProperty("user.dir")+path);
        if (f.isFile()) return f;
        throw new InvalidPathException(f.getAbsolutePath(),"Cannot find valid file within that path");
    }

    public static ArrayList<String> LoadTextFile(File file) {
        ArrayList<String> fileAsStringArray = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                fileAsStringArray.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileAsStringArray;
    }

    public static String promptMsg(String msg){
        Output.ShowOutput(msg);
        return userInput.nextLine();
    }
}
