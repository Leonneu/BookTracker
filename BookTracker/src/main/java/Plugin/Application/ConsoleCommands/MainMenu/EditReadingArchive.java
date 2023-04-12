package Plugin.Application.ConsoleCommands.MainMenu;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.State;

public class EditReadingArchive implements ConsoleCommand {
    public EditReadingArchive() {
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
