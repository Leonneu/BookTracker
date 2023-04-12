package Plugin.Application.ConsoleCommands.MainMenu;

import Plugin.IO.Output;
import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.State;

public class ShowReadingList implements ConsoleCommand {
    Container container;

    public ShowReadingList(Container container) {
        this.container = container;
    }

    @Override
    public State execute() {
        Output.showHeaderReadingList();
        Output.showOutput(container.getReadingList().toString().replace(";",Output.lineBreak));
        return State.SHOWREADINGLIST;
    }

    @Override
    public String name() {
        return "Leseliste anzeigen";
    }

    @Override
    public String description() {
        return "Zeigt die Leseliste an";
    }
}
