package StateLogic;

public class LoadLibrary extends ConsoleCommand {
    public LoadLibrary(DIContainer container) {
        super(container);
    }

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
