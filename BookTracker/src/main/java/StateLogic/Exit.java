package StateLogic;

public class Exit implements IConsoleCommand {
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
