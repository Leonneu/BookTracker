package Plugin.Application.ConsoleCommands;

import Plugin.Application.State;

public interface ConsoleCommand {

    public abstract State execute();
    public abstract String name();
    public abstract String description();

}
