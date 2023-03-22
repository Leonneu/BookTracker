package Model.ConsoleCommands.MainMenu;

import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;

public class EditReadingList implements ConsoleCommand {
    private DIContainer container;
    public EditReadingList(DIContainer container) {
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
