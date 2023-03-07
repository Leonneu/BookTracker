package StateLogic;

public class DeleteBook implements IConsoleCommand {
    @Override
    public State execute() {
        return null;
    }

    @Override
    public String name() {
        return "Buch entfernen";
    }

    @Override
    public String description() {
        return "Entferenen eines Buches aus der Bibliothek";
    }
}
