package Plugin.Application.ConsoleCommands.ShowStatistics;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.State;

public class MonthReport implements ConsoleCommand {
    private final Container container;

    public MonthReport(Container container) {
        this.container = container;
    }

    @Override
    public State execute() {

        return State.STATISTIC;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public String description() {
        return null;
    }
}
