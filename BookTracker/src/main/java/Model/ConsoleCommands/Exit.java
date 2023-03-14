package Model.ConsoleCommands;

import Model.Data.DIContainer;
import Model.State;

public class Exit implements ConsoleCommand {
    @Override
    public State execute() {
        return State.EXIT;
    }

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public String description() {
        return "Exits the program.";
    }
}
