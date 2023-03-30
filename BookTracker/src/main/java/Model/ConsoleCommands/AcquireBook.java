package Model.ConsoleCommands;

import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;

public class AcquireBook implements ConsoleCommand {
    DIContainer container;

    public AcquireBook(DIContainer container) {
        this.container = container;
    }

    @Override
    public State execute() {
        return null;
    }

    @Override
    public String name() {
        return "Buch zur Sammlung hinzufügen";
    }

    @Override
    public String description() {
        return null;
    }
}
