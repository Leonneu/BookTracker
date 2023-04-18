package Plugin.Application.ConsoleCommands.ShowReadingList;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.Model.ReadingList;
import Plugin.Application.State;
import Plugin.IO.Builder.ListOutputBuilder;
import Plugin.IO.Builder.OutputBuilder;
import Plugin.IO.Output;

public class ShowOwnedBooks implements ConsoleCommand {
    private final Container container;

    public ShowOwnedBooks(Container container) {
        this.container=container;
    }

    @Override
    public State execute() {
        ReadingList readingList = container.getReadingList();
        var result = readingList.getOwnedBooks();
        OutputBuilder builder = new ListOutputBuilder();
        for (var e:result
        ) {
            builder.append(e);
        }
        Output.showOutput(builder.finalise());
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
