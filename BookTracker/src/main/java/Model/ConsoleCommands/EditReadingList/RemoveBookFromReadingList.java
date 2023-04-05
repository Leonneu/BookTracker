package Model.ConsoleCommands.EditReadingList;

import IO.Input;
import IO.Output;
import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.Data.ReadingList;
import Model.Data.ReadingListEntry;
import Model.State;

import java.util.List;

public class RemoveBookFromReadingList implements ConsoleCommand {
    private DIContainer container;

    public RemoveBookFromReadingList(DIContainer container) {
        this.container = container;
    }

    @Override
    public State execute() {
        ReadingList readingList = container.getReadingList();
        String title = Input.promptMsg("Titel");
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
        readingList.removeEntry(readingListEntry);
        Output.showOutput("Eintrag erfolgreich gelöscht");
        return State.MAIN;
    }

    @Override
    public String name() {
        return "Buch entfernen";
    }

    @Override
    public String description() {
        return "Entferenen eines Buches aus der Bibliothek";
    }
}
