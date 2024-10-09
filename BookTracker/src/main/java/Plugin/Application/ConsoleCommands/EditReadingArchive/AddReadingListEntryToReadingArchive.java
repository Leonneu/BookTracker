package Plugin.Application.ConsoleCommands.EditReadingArchive;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.Model.BookDateWrapper;
import Plugin.Application.Model.ReadingArchiveEntry;
import Plugin.Application.Model.ReadingList;
import Plugin.Application.Model.ReadingListEntry;
import Plugin.Application.State;
import Plugin.IO.Input;
import Plugin.IO.Output;

import java.util.List;

public class AddReadingListEntryToReadingArchive implements ConsoleCommand {
    private final Container container;

    public AddReadingListEntryToReadingArchive(Container container) {
        this.container = container;
    }

    @Override
    public State execute() {
        String title = Input.promptMsg("Titel?");
        ReadingList readingList = container.getReadingList();
        List<ReadingListEntry> results = readingList.searchByTitle(title);
        ReadingListEntry readingListEntry;
        switch (results.size()) {
            case 0 -> {
                Output.showOutput("Keine Buch mit diesem Titel in der Leseliste");
                return State.EDITREADINGARCHIVE;
            }
            case 1 -> readingListEntry = results.get(0);
            default -> readingListEntry = Input.promptUserForListChoice(results);
        }
        System.out.println("Geben Sie das Startdatum an");
        BookDateWrapper startDate = Input.promptUserForDate();
        System.out.println("Geben Sie das Enddatum an");
        BookDateWrapper endDate = Input.promptUserForDate();
        String comment = Input.promptMsg("Notiz oder Kommentar?");
        if (comment.isEmpty()) {
            comment = "-";
        }
        readingList.removeEntry(readingListEntry);
        container.getReadingArchive().AddEntry(new ReadingArchiveEntry(readingListEntry.book(),startDate,endDate,comment));
        return State.MAIN;
    }

    @Override
    public String name() {
        return "Von der Leseliste";
    }

    @Override
    public String description() {
        return "Füge einen Titel aus der Leseliste zum Archive hinzu, der Titel wird von der Leseliste entfernt.";
    }
}
