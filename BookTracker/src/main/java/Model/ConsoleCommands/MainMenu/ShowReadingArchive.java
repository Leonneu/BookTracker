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
        Output.ShowOutput("Titel|Autor|Seitenzahl|Genre|Lesestart|Leseende|Notiz");
        Output.ShowOutput(container.GetReadingArchive().toString());
        return State.MAIN;
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
