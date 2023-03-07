package StateLogic;

public class ShowLibrary extends ConsoleCommand {
    public ShowLibrary(DIContainer container) {
        super(container);
    }

    @Override
    public State execute() {
        return State.MAIN;
    }

    @Override
    public String name() {
        return "Show Books in Library";
    }

    @Override
    public String description() {
        return "Shows all the Books currently in the Library";
    }
}
