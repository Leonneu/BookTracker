package Model.ConsoleCommands.MainMenu;

import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;

public class EditLibrary implements ConsoleCommand {
    private DIContainer container;
    public EditLibrary(DIContainer container) {
        this.container=container;
    }

    @Override
    public State execute() {
        return State.EDITLIBRARY;
    }

    @Override
    public String name() {
        return "Bibliothek bearbeiten";
    }

    @Override
    public String description() {
        return "Öffnet die Optionen zur Bearbeitung der Bibliothek";
    }
}
