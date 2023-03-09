package Model.ConsoleCommands.MainMenu;

import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;

public class EditLibrary extends ConsoleCommand {
    public EditLibrary(DIContainer container) {
        super(container);
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
