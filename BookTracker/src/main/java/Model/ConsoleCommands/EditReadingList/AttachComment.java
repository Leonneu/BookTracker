package Model.ConsoleCommands.EditReadingList;

import IO.Input;
import IO.Output;
import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.Data.ReadingList;
import Model.Data.ReadingListEntry;
import Model.State;

public class AttachComment implements ConsoleCommand {
    private final DIContainer container;

    public AttachComment(DIContainer container) {
        this.container = container;
    }

    @Override
    public State execute() {
        String title = Input.promptMsg("Titel?");
        ReadingList readingList = container.getReadingList();
        var results = readingList.searchByTitle(title);
        ReadingListEntry readingListEntry;
        switch (results.size()) {
            case 0 -> {
                Output.showOutput("Keine Buch mit diesem Titel in der Leseliste");
                return State.EDITREADINGARCHIVE;
            }
            case 1 -> readingListEntry = results.get(0);
            default -> readingListEntry = Input.promptUserForListChoice(results);
        }
        String comment = Input.promptMsg("Notiz:");
        readingListEntry.setComment(comment);
        Output.showOutput("Notiz gespeichert!");
        return State.EDITREADINGLIST;
    }

    @Override
    public String name() {
        return "Notiz zu Eintrag hinzufügen";
    }

    @Override
    public String description() {
        return null;
    }
}
