package Model.ConsoleCommands;

import IO.Input;
import Model.Data.*;
import Model.State;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LoadLibrary implements ConsoleCommand {
    private final DIContainer container;

    public LoadLibrary(DIContainer container) {
        this.container = container;
    }

    @Override
    public State execute() {
        String path = Input.promptMsg("Pfad zur Datei angeben:");
        File fullPath = Input.parseFilePath(path);
        container.setPath(fullPath);
        ArrayList<String> content = Input.LoadTextFile(fullPath);
        int splitIndex = FindSeparatorIndex(content);
        ArrayList<ReadingListEntry> readingListContent;

        if (splitIndex != 0) {
            readingListContent = ParseStringToListEntries(content.subList(0, splitIndex));
        } else {
            readingListContent = new ArrayList<>();
        }
        ArrayList<ReadingArchiveEntry> readingArchiveContent;
        if (splitIndex != content.size() - 1) {
            readingArchiveContent = ParseStringToArchiveEntries(content.subList(splitIndex + 1, content.size()));
        } else {
            readingArchiveContent = new ArrayList<>();
        }

        container.SetReadingArchive(new ReadingArchive(readingArchiveContent));
        container.setReadingList(new ReadingList(readingListContent));
        return State.MAIN;
    }

    private ArrayList<ReadingListEntry> ParseStringToListEntries(List<String> subList) {
        ArrayList<ReadingListEntry> result = new ArrayList<>();
        for (String str : subList
        ) {
            var values = str.split("\\|");
            Book b = new Book(values[0], values[1], Integer.parseInt(values[2].trim()), Language.valueOf(values[3].trim()), Genre.parseGenreSet(values[4].trim().split(",")));
            ReadingListEntry entry = new ReadingListEntry(b, values[5].trim().equals("Ja"), values[6]);
            result.add(entry);
        }
        return result;
    }

    private ArrayList<ReadingArchiveEntry> ParseStringToArchiveEntries(List<String> subList) {
        ArrayList<ReadingArchiveEntry> result = new ArrayList<>();
        for (String str : subList
        ) {
            var values = str.split("\\|");
            Book b = new Book(values[0], values[1], Integer.parseInt(values[2].trim()), Language.valueOf(values[3].trim()), Genre.parseGenreSet(values[4].trim().split(",")));
            Date dateStart;
            if (!values[5].trim().equals("-")) {
                var dateStr = values[5].trim().split("\\.");
                dateStart = new Date(Integer.parseInt(dateStr[0]), Integer.parseInt(dateStr[1]), Integer.parseInt(dateStr[2]));
            } else {
                dateStart = null;
            }
            Date dateEnd;
            if (!values[6].trim().equals("-")) {
                var dateStr = values[6].trim().split("\\.");
                dateEnd = new Date(Integer.parseInt(dateStr[0]), Integer.parseInt(dateStr[1]), Integer.parseInt(dateStr[2]));
            } else {
                dateEnd = null;
            }
            result.add(new ReadingArchiveEntry(b, dateStart, dateEnd, values[7]));
        }
        return result;
    }

    //TODO Naming and Arraylist => List, Magic string "---"
    private int FindSeparatorIndex(ArrayList<String> listOfStrings) {
        return listOfStrings.indexOf("---");
    }

    @Override
    public String name() {
        return "Bibliothek laden";
    }

    @Override
    public String description() {
        return "Lade eine Bibliothek Datei. Es muss ein Dateipfad angegeben werden (absolut oder relativ).";
    }
}
