package Model.ConsoleCommands.ShowReadingArchive;

import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;

public class ShowReadingArchiveByTitle implements ConsoleCommand {
    DIContainer container;

    public ShowReadingArchiveByTitle(DIContainer container) {
        this.container = container;
    }

    @Override
    public State execute() {
        return null;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public String description() {
        return null;
    }
}
