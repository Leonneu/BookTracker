package Plugin.Application.ConsoleCommands.EditReadingArchive;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.State;

public class AddReadingArchiveEntryManually implements ConsoleCommand {
    Container container;
    public AddReadingArchiveEntryManually(Container container) {
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
