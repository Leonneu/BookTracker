package Model.ConsoleCommands;

import Model.Data.DIContainer;
import Model.State;

public class Cancel implements ConsoleCommand {
    @Override
    public State execute() {
        return State.MAIN;
    }

    @Override
    public String name() {
        return "Abbrechen";
    }

    @Override
    public String description() {
        return "Zurück ins Hauptmenü";
    }
}
