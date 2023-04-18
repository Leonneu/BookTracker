package Plugin.Application.ConsoleCommands.ShowStatistics;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.State;

public class YearReport implements ConsoleCommand {
    Container container;
    public YearReport(Container container) {
        this.container = container;
    }

    @Override
    public State execute() {
        return State.STATISTIC;
    }

    @Override
    public String name() {
        return "Generiere Jahres Statistik";
    }

    @Override
    public String description() {
        return null;
    }
}
