package StateLogic;

public class ShowWishList extends ConsoleCommand {
    public ShowWishList(DIContainer container) {
        super(container);
    }

    @Override
    public State execute() {
        return null;
    }

    @Override
    public String name() {
        return "Wunschliste anzeigen";
    }

    @Override
    public String description() {
        return "Zeigt die Wunschliste an";
    }
}
