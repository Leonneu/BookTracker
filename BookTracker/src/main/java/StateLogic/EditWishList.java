package StateLogic;

public class EditWishList implements IConsoleCommand {
    @Override
    public State execute() {
        return null;
    }

    @Override
    public String name() {
        return "Wunschliste bearbeiten";
    }

    @Override
    public String description() {
        return "Öffnet die Optionen zur Bearbeitung der Bibliothek";
    }
}
