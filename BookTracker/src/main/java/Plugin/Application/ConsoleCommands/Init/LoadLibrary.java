package Plugin.Application.ConsoleCommands.Init;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.Model.*;
import Plugin.Application.State;
import Plugin.IO.Input;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LoadLibrary implements ConsoleCommand {
    private final Container container;

    public LoadLibrary(Container container) {
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

        container.setReadingArchive(new ReadingArchive(readingArchiveContent));
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
            BookDateWrapper dateStart = parseDateFromString(values[5]);
            BookDateWrapper dateEnd = parseDateFromString(values[6]);
            result.add(new ReadingArchiveEntry(b, dateStart, dateEnd, values[7]));
        }
        return result;
    }

    private static BookDateWrapper parseDateFromString(String dateAsString) {
        BookDateWrapper dateStart;
        if (!dateAsString.trim().equals("-")) {
            var dateStr = dateAsString.trim().split("\\.");
            dateStart = new BookDateWrapper(Integer.parseInt(dateStr[0]), Integer.parseInt(dateStr[1]), Integer.parseInt(dateStr[2]));
        } else {
            dateStart = null;
        }
        return dateStart;
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
