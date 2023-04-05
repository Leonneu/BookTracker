package Model.ConsoleCommands.ShowReadingList;

import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;

public class ShowReadingListByTitle implements ConsoleCommand {
    private final DIContainer container;

    public ShowReadingListByTitle(DIContainer container) {
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
