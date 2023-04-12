package Plugin.Application.ConsoleCommands.ShowReadingList;

import Plugin.IO.Output;
import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.Model.ReadingList;
import Plugin.Application.State;

public class ShowOwnedBooks implements ConsoleCommand {
    private final Container container;

    public ShowOwnedBooks(Container container) {
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
