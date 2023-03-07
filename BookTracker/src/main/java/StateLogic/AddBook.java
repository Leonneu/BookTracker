package StateLogic;

public class AddBook implements IConsoleCommand {
    @Override
    public State execute() {
        return null;
    }

    @Override
    public String name() {
        return "Buch hinzufügen";
    }

    @Override
    public String description() {
        return "Ein Buch zur aktuellen Bibliothek hinzufügen";
    }
}
