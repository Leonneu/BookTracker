package Model.ConsoleCommands.EditReadingList;

import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.Data.Library;
import Model.State;

public class AddBookManually implements ConsoleCommand {
    private DIContainer container;
    private Library library;
    public AddBookManually(DIContainer container) {
     this.container = container;
    }
    @Override
    public State execute() {
        return State.MAIN;
    }

    @Override
    public String name() {
        return "Manually";
    }

    @Override
    public String description() {
        return null;
    }
}
