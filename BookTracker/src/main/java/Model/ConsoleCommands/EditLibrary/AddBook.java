package Model.ConsoleCommands.EditLibrary;

import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;

public class AddBook implements ConsoleCommand {
    private DIContainer container;
    public AddBook(DIContainer container){
        this.container=container;
    }

    @Override
    public State execute() {
        return State.ADDBOOKTOLIBRARY;
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
