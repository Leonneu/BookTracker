package Model.ConsoleCommands.EditReadingList;

import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;

public class AddBookToReadingList implements ConsoleCommand {
    private DIContainer container;
    public AddBookToReadingList(DIContainer container){
        this.container=container;
    }

    @Override
    public State execute() {
        return State.ADDBOOKTOREADINGLIST;
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
