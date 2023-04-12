package Plugin.Application.ConsoleCommands.MainMenu;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.State;

public class EditReadingArchive implements ConsoleCommand {
    private Container container;
    public EditReadingArchive(Container container) {
        this.container=container;
    }

    @Override
    public State execute() {
        return State.EDITREADINGARCHIVE;
    }

    @Override
    public String name() {
        return "Lesearchive bearbeiten";
    }

    @Override
    public String description() {
        return "Öffnet die Optionen zur Bearbeitung der Bibliothek";
    }
}
