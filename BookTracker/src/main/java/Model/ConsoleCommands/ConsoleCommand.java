package Model.ConsoleCommands;

import Model.Data.DIContainer;
import Model.State;

public interface ConsoleCommand {

    public abstract State execute();
    public abstract String name();
    public abstract String description();

}
