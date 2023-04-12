package Plugin.Application.ConsoleCommands.MainMenu;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.State;

public class ShowStatistics implements ConsoleCommand {
    private final Container container;
    public ShowStatistics(Container container) {
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
