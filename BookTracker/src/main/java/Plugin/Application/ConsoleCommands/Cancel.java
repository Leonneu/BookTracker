package Plugin.Application.ConsoleCommands;

import Plugin.Application.State;

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
