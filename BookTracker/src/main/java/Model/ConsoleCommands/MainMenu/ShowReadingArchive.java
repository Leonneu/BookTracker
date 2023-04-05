package Model.ConsoleCommands.MainMenu;

import IO.Output;
import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;

public class ShowReadingArchive implements ConsoleCommand {
    private DIContainer container;
    public ShowReadingArchive(DIContainer container) {
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
