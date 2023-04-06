package Model.ConsoleCommands.ShowReadingList;

import IO.Output;
import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.Data.ReadingList;
import Model.State;

public class ShowOwnedBooks implements ConsoleCommand {
    private final DIContainer container;

    public ShowOwnedBooks(DIContainer container) {
        this.container=container;
    }

    @Override
    public State execute() {
        ReadingList readingList = container.getReadingList();
        var result = readingList.getOwnedBooks();
        StringBuilder output = new StringBuilder();
        for (var e:result
        ) {
            output.append(e.toString()).append(Output.lineBreak);
        }
        Output.showHeaderReadingList();
        Output.showOutput(output.toString());
        return State.SHOWREADINGLIST;
    }

    @Override
    public String name() {
        return "Bessesene Bücher anzeigen";
    }

    @Override
    public String description() {
        return null;
    }
}
