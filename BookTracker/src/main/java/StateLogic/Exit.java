package StateLogic;

public class Exit extends ConsoleCommand {
    public Exit(DIContainer container) {
        super(container);
    }

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
