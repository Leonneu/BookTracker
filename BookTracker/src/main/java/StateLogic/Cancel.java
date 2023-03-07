package StateLogic;

public class Cancel extends ConsoleCommand {
    public Cancel(DIContainer container) {
        super(container);
    }

    @Override
    public State execute() {
        return null;
    }

    @Override
    public String name() {
        return "Abbrechen";
    }

    @Override
    public String description() {
        return "Zurück ins Hauptmenü";
    }
}
