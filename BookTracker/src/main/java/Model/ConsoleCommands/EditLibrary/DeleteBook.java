package Model.ConsoleCommands.EditLibrary;

import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;

public class DeleteBook extends ConsoleCommand {
    public DeleteBook(DIContainer container) {
        super(container);
    }

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
