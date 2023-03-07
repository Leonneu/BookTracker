package StateLogic;

public class Cancle implements IConsoleCommand {
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
