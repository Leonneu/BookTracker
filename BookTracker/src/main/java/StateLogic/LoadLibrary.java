package StateLogic;

public class LoadLibrary implements IConsoleCommand{
    @Override
    public State execute() {

        return State.MAIN;
    }

    @Override
    public String name() {
        return "Bibliothek laden";
    }

    @Override
    public String description() {
        return "Lade eine Bibliothek Datei. Es muss ein Dateipfad angegeben werden.";
    }
}
