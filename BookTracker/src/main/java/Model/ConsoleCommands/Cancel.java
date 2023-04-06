package Model.ConsoleCommands;

import Model.State;

public class Cancel implements ConsoleCommand {
    @Override
    public State execute() {
        return State.MAIN;
    }

    @Override
    public String name() {
        return "Zurück";
    }

    @Override
    public String description() {
        return "Zurück ins Hauptmenü";
    }
}
