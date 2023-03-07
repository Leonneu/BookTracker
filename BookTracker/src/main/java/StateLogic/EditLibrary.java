package StateLogic;

public class EditLibrary extends ConsoleCommand {
    public EditLibrary(DIContainer container) {
        super(container);
    }

    @Override
    public State execute() {
        return null;
    }

    @Override
    public String name() {
        return "Bibliothek bearbeiten";
    }

    @Override
    public String description() {
        return "Öffnet die Optionen zur Bearbeitung der Bibliothek";
    }
}
