package Model.ConsoleCommands.MainMenu;

import IO.Output;
import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;

public class ShowReadingList implements ConsoleCommand {
    DIContainer container;

    public ShowReadingList(DIContainer container) {
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
