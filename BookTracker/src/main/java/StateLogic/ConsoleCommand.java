package StateLogic;

public abstract class ConsoleCommand {

    private DIContainer container;
    public ConsoleCommand(DIContainer container){
        this.container = container;
    }
    public abstract State execute();
    public abstract String name();
    public abstract String description();

}
