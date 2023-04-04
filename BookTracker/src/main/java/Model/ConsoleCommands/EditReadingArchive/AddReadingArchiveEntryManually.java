package Model.ConsoleCommands.EditReadingArchive;

import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;

public class AddReadingArchiveEntryManually implements ConsoleCommand {
    DIContainer container;
    public AddReadingArchiveEntryManually(DIContainer container) {
        this.container=container;
    }

    @Override
    public State execute() {
        return null;
    }

    @Override
    public String name() {
        return "Buch manuell ins Archive hinzufügen";
    }

    @Override
    public String description() {
        return null;
    }
}
