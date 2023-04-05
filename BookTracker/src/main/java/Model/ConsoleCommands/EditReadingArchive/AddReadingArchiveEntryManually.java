package Model.ConsoleCommands.EditReadingArchive;

import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;
import jdk.jshell.spi.ExecutionControl;

public class AddReadingArchiveEntryManually implements ConsoleCommand {
    DIContainer container;
    public AddReadingArchiveEntryManually(DIContainer container) {
        this.container=container;
    }

    @Override
    public State execute() {
        return null;//TODO
    }

    @Override
    public String name() {
        return "Buch manuell ins Archive hinzufügen";
    }

    @Override
    public String description() {
        return "Füge ein Buch direkt in das Archive hinzu, sollte nur in Ausnahme Fällen verwendet werden";
    }
}
