package Plugin.Application.ConsoleCommands.MainMenu;

import Plugin.IO.Output;
import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.State;

public class ShowReadingArchive implements ConsoleCommand {
    private Container container;
    public ShowReadingArchive(Container container) {
        this.container = container;
    }

    @Override
    public State execute() {
        Output.showHeaderReadingArchive();
        Output.showOutput(container.GetReadingArchive().toString().replace(";", Output.lineBreak));
        return State.SHOWREADINGARCHIVE;
    }

    @Override
    public String name() {
        return "Lesearchive anzeigen";
    }

    @Override
    public String description() {
        return "Shows all the Books currently in the Library";
    }
}
