package Model.ConsoleCommands.MainMenu;

import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;

public class ShowStatistics implements ConsoleCommand {
    private DIContainer container;
    public ShowStatistics(DIContainer container) {
        this.container = container;
    }

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
