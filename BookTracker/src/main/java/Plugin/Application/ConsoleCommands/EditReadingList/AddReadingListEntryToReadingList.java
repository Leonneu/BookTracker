package Plugin.Application.ConsoleCommands.EditReadingList;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.State;

public class AddReadingListEntryToReadingList implements ConsoleCommand {
    public AddReadingListEntryToReadingList(){
    }

    @Override
    public State execute() {
        return State.ADDBOOKTOREADINGLIST;
    }

    @Override
    public String name() {
        return "Buch hinzufügen";
    }

    @Override
    public String description() {
        return "Ein Buch zur aktuellen Bibliothek hinzufügen";
    }
}
