package Model.ConsoleCommands.EditReadingList;

import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;

public class RemoveBookFromReadingList implements ConsoleCommand {
    private DIContainer container;

    public RemoveBookFromReadingList(DIContainer container) {
        this.container = container;
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
