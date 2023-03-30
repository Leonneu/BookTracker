package Model.ConsoleCommands.MainMenu;

import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;

public class EditReadingArchive implements ConsoleCommand {
    private DIContainer container;
    public EditReadingArchive(DIContainer container) {
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
