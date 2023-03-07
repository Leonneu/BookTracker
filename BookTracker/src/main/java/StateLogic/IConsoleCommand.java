package StateLogic;

public interface IConsoleCommand {
    State execute();
    String name();
    String description();

}
