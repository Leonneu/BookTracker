package Model.ConsoleCommands.EditReadingArchive;

import IO.Input;
import IO.Output;
import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.*;
import Model.State;

import java.util.List;

public class AddReadingListEntryToReadingArchive implements ConsoleCommand {
    private final DIContainer container;

    public AddReadingListEntryToReadingArchive(DIContainer container) {
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
        BookDateWrapper startDate = Input.promptUserForDate();
        BookDateWrapper endDate = Input.promptUserForDate();
        String comment = Input.promptMsg("Notiz oder Kommentar?");
        if (comment.isEmpty()) {
            comment = "-";
        }
        readingList.removeEntry(readingListEntry);
        container.GetReadingArchive().AddEntry(new ReadingArchiveEntry(readingListEntry.book(),startDate,endDate,comment));
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
