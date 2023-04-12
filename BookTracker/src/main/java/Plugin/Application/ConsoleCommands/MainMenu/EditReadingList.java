package Plugin.Application.ConsoleCommands.MainMenu;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.State;

public class EditReadingList implements ConsoleCommand {
    public EditReadingList() {
    }

    @Override
    public State execute() {
        return State.EDITREADINGLIST;
    }

    @Override
    public String name() {
        return "Leseliste bearbeiten";
    }

    @Override
    public String description() {
        return "Öffnet die Optionen zur Bearbeitung der Bibliothek";
    }
}
