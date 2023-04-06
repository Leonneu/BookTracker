package IO;

import Model.Data.BookDateWrapper;
import Model.Data.Genre;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final Scanner userInput = new Scanner(System.in);

    public static int GetOption(int numberOfValidOptions) throws InvalidOptionException {
        int selectedOption;
        try {
            selectedOption = Integer.parseInt(userInput.nextLine());
            userInput.reset();
        }catch (Exception e){
            throw new InvalidOptionException("Invalide Option");
        }

        if (0 <= selectedOption && selectedOption < numberOfValidOptions)
            return selectedOption;
        throw new InvalidOptionException("Invalide Option");
    }

    public static File parseFilePath(String path) throws InvalidPathException {
        var testIf = new File(path);
        if(testIf.isAbsolute() && testIf.isFile()) return testIf;
        File f = new File(System.getProperty("user.dir") + (path.startsWith("\\")?"":"\\") + path);
        if (f.isFile()) return f;
        throw new InvalidPathException(f.getAbsolutePath(),"Keine Datei mit diesem Pfad gefunden");
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
        Output.showOutput(msg);
        return userInput.nextLine();
    }

    public static EnumSet<Genre> promptUserForGenres() {
        EnumSet<Genre> result = EnumSet.noneOf(Genre.class);
        String[] options = Genre.getNames();
        boolean itWorked = false;
        do {
            Output.showOutput(Output.parseGenreOptions(options));
            String selectedOptions = Input.promptMsg("Geben Sie alle zutreffenden Kategorien an:");
            try{
                for (char c:selectedOptions.toCharArray()
                ) {
                    //TODO remove magic Int
                    result.add(Genre.valueOf(options[c-48]));
                }
            }catch (Exception e){
                itWorked=true;
                Output.showOutput(e.getMessage());
            }
        }while (itWorked);
        return result;
    }

    public static BookDateWrapper promptUserForDate(){
        boolean validInput=false;
        BookDateWrapper result = null;
        do{
            String userInput = Input.promptMsg("Datum im folgenden Format angeben: tt.mm.jjjj. z.B. 01.01.2020");
            var values = userInput.split("\\.");
            if(values.length==3){
                try {
                    int day = Integer.parseInt(values[0]);
                    int month = Integer.parseInt(values[1]);
                    int year = Integer.parseInt(values[2]);
                    result = new BookDateWrapper(day,month,year);
                    validInput = true;
                }catch (Exception e){
                    Output.showOutput(e.getMessage());
                }
            }
            if(values.length==1){
                result = new BookDateWrapper();
                validInput=true;
            }
        }while (!validInput);
        return result;
    }

    public static <T> T promptUserForListChoice(List<T> list)  {
        int n = list.size();
        Output.showOutput("List contents:");
        for (int i = 0; i < n; i++) {
            Output.showOutput(i+". "+list.get(i).toString());
        }
        boolean stillChoosing = true;
        int selectedOption=0;
        while(stillChoosing){
            try {
                selectedOption = GetOption(n);
                stillChoosing=false;
            } catch (InvalidOptionException e) {
                Output.showOutput(e.getMessage());
                Output.showOutput("Try again");
            }
        }
        return list.get(selectedOption);
    }


}
