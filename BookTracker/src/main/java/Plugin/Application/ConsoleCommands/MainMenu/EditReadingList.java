package Plugin.Application.ConsoleCommands.MainMenu;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.State;

public class EditReadingList implements ConsoleCommand {
    private Container container;
    public EditReadingList(Container container) {
        this.container = container;
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
