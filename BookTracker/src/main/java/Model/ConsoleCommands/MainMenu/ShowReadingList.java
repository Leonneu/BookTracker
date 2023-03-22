package Model.ConsoleCommands.MainMenu;

import IO.Output;
import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;

public class ShowReadingList implements ConsoleCommand {
    DIContainer container;
    public ShowReadingList(DIContainer container) {
        this.container=container;
    }

    @Override
    public State execute() {
        Output.ShowOutput(container.GetReadingList().toString());

        return State.MAIN;
    }

    @Override
    public String name() {
        return "Wunschliste anzeigen";
    }

    @Override
    public String description() {
        return "Zeigt die Wunschliste an";
    }
}
