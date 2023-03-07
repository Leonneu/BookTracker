package StateLogic;

public class ShowStatistics implements IConsoleCommand {
    @Override
    public State execute() {
        return null;
    }

    @Override
    public String name() {
        return "Statistiken anzeigen";
    }

    @Override
    public String description() {
        return "Öffnet das Statistik Menü";
    }
}
