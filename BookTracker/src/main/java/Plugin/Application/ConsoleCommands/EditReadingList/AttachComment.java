package Plugin.Application.ConsoleCommands.EditReadingList;

import Plugin.IO.Input;
import Plugin.IO.Output;
import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.Model.ReadingList;
import Plugin.Application.Model.ReadingListEntry;
import Plugin.Application.State;

public class AttachComment implements ConsoleCommand {
    private final Container container;

    public AttachComment(Container container) {
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
        return "Fügt eine persönliche Notiz zu einem Eintrag hinzu.";
    }
}
