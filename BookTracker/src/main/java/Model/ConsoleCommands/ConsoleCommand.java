package Model.ConsoleCommands;

import Model.Data.DIContainer;
import Model.State;

public abstract class ConsoleCommand {

    protected final DIContainer container;
    public ConsoleCommand(DIContainer container){
        this.container = container;
    }
    public abstract State execute();
    public abstract String name();
    public abstract String description();

}
