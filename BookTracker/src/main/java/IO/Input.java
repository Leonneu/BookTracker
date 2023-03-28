package IO;

import Model.Data.Book;
import Model.Data.Date;
import Model.Data.Genre;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.*;
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

    public static EnumSet<Genre> promptUserForGenres() {
        EnumSet<Genre> result = EnumSet.noneOf(Genre.class);
        String[] options = Genre.getNames();
        int n = options.length;
        boolean itWorked = false;
        do {
            Output.ShowOutput(Output.ParseGenreOptions(options));
            String selectedOptions = Input.promptMsg("Geben Sie alle zutreffenden Kategorien an:");
            try{
                for (char c:selectedOptions.toCharArray()
                ) {
                    //TODO remove magic Int
                    result.add(Genre.valueOf(options[c-48]));
                }
            }catch (Exception e){
                itWorked=true;
                Output.ShowOutput(e.getMessage());
            }
        }while (itWorked);
        return result;
    }

    public static Date promptUserForDate(){
        boolean validInput=false;
        Date result = null;
        do{
            String userInput = Input.promptMsg("Datum im folgenden format angeben: tt.mm.jjjj. z.B. 01.01.2020");
            var values = userInput.split(".");
            if(values.length==3){
                try {
                    int day = Integer.parseInt(values[0]);
                    int month = Integer.parseInt(values[1]);
                    int year = Integer.parseInt(values[2]);
                    result = new Date(day,month,year);
                }catch (Exception e){
                    Output.ShowOutput(e.getMessage());
                }
            }
        }while (!validInput);
        return result;
    }


}
