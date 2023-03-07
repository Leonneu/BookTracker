package StateLogic;

public class EditWishList extends ConsoleCommand {
    public EditWishList(DIContainer container) {
        super(container);
    }

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
