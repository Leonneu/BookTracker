package Model.ConsoleCommands.EditReadingList;

import IO.Input;
import IO.Output;
import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.Data.ReadingList;
import Model.Data.ReadingListEntry;
import Model.State;

public class AcquireBook implements ConsoleCommand {
    DIContainer container;

    public AcquireBook(DIContainer container) {
        this.container = container;
    }

    @Override
    public State execute() {
        String title = Input.promptMsg("Titel?");
        ReadingList readingList = container.getReadingList();
        var results = readingList.searchByTitle(title);
        switch (results.size()) {
            case 0 -> {
                Output.showOutput("Keine Buch mit diesem Titel in der Leseliste");
                return State.EDITREADINGLIST;
            }
            case 1 -> {
                var e = results.get(0);
                e.acquireBook();
                Output.showOutput("Buch ist nun in ihrem Besitzt!");
                return State.MAIN;
            }
            default -> {
                ReadingListEntry entry = Input.promptUserForListChoice(results);
                Output.showOutput("Buch ist nun in ihrem Besitzt!");
                entry.acquireBook();
            }
        }
        return State.MAIN;
    }

    @Override
    public String name() {
        return "Buch zur Sammlung hinzufügen";
    }

    @Override
    public String description() {
        return "Buch erwerben";
    }
}