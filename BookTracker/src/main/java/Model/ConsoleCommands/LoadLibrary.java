package Model.ConsoleCommands;

import IO.Input;
import Model.*;
import Model.Data.*;

import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class LoadLibrary implements ConsoleCommand {
    private DIContainer container;

    public LoadLibrary(DIContainer container) {
        this.container = container;
    }

    @Override
    public State execute() {
        String path = Input.promptMsg("Enter File path");
        if(!Input.validateFilePath(path)) throw new InvalidPathException(path,"is not a valid path");
        ArrayList<String> content = Input.LoadTextFile(Input.parseFilePath(path));
        int splitIndex = FindSeparatorIndex(content);
        ArrayList<ReadingListEntry> readingListContent = ParseStringToListEntries(content.subList(0,splitIndex));
        ArrayList<ReadingArchiveEntry> readingArchiveContent = ParseStringToArchiveEntries(content.subList(splitIndex+1,content.size()));
        container.SetReadingArchive(new ReadingArchive(readingArchiveContent));
        container.SetReadingList(new ReadingList(readingListContent));
        return State.MAIN;
    }

    private ArrayList<ReadingListEntry> ParseStringToListEntries(List<String> subList) {
        ArrayList<ReadingListEntry> result = new ArrayList<>();
        for (String str:subList
             ) {
            var values = str.split("\\|");
            Book b = new Book(values[0],values[1],Integer.parseInt(values[2]),Language.valueOf(values[3]),Genre.parseGenreSet(values[4].split(",")));
            ReadingListEntry entry = new ReadingListEntry(b,Boolean.parseBoolean(values[5]),values[6]);
            result.add(entry);
        }
        return result;
    }

    private ArrayList<ReadingArchiveEntry> ParseStringToArchiveEntries(List<String> subList) {
        ArrayList<ReadingArchiveEntry> result = new ArrayList<>();
        for (String str:subList
             ) {
            var values = str.split("\\|");
            Book b = new Book(values[0],values[1],Integer.parseInt(values[2]),Language.valueOf(values[3]),Genre.parseGenreSet(values[4].split(",")));
            Date dateStart;
            if(!values[5].equals("-")){
                var dateStr = values[5].split("\\.");
                dateStart = new Date(Integer.parseInt(dateStr[0]),Integer.parseInt(dateStr[1]),Integer.parseInt(dateStr[2]));
            }else{
                dateStart = null;
            }
            Date dateEnd;
            if(!values[6].equals("-")){
                var dateStr = values[6].split("\\.");
                dateEnd = new Date(Integer.parseInt(dateStr[0]),Integer.parseInt(dateStr[1]),Integer.parseInt(dateStr[2]));
            }else{
                dateEnd = null;
            }
            result.add(new ReadingArchiveEntry(b,dateStart,dateEnd,Boolean.parseBoolean(values[7]),values[8]));
        }
        return result;
    }

    //TODO Naming and Arraylist => List, Magic string "---"
    private int FindSeparatorIndex(ArrayList<String> listOfStrings){
        return listOfStrings.indexOf("---");
    }

    private ArrayList<Book> StringArrayToBooksArray(ArrayList<String> booksAsString) {
        ArrayList<Book> result = new ArrayList<>();
        for (String str : booksAsString
        ) {
            var values = str.split("\\|");
            Book b = new Book(values[0], values[1], EnumSet.of(Genre.valueOf(values[2])));
            result.add(b);
        }
        return result;
    }

    @Override
    public String name() {
        return "Bibliothek laden";
    }

    @Override
    public String description() {
        return "Lade eine Bibliothek Datei. Es muss ein Dateipfad angegeben werden.";
    }
}
