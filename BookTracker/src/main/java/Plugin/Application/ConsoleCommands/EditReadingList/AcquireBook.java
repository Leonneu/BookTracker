package Plugin.Application.ConsoleCommands.EditReadingList;

import Plugin.IO.Input;
import Plugin.IO.Output;
import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.Model.ReadingList;
import Plugin.Application.Model.ReadingListEntry;
import Plugin.Application.State;

public class AcquireBook implements ConsoleCommand {
    Container container;

    public AcquireBook(Container container) {
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
