package Plugin.Application.ConsoleCommands.ShowReadingList;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.Model.ReadingList;
import Plugin.Application.State;
import Plugin.IO.Builder.OutputBuilder;
import Plugin.IO.Output;

public class ShowOwnedBooks implements ConsoleCommand {
    private final Container container;
    private final OutputBuilder builder;

    public ShowOwnedBooks(Container container, OutputBuilder builder) {
        this.container = container;
        this.builder = builder;
    }

    @Override
    public State execute() {
        ReadingList readingList = container.getReadingList();
        var result = readingList.getOwnedBooks();
        builder.reset();
        for (var e : result
        ) {
            builder.append(e);
        }
        Output.showOutput(builder.finalise());
        return State.SHOWREADINGLIST;
    }

    @Override
    public String name() {
        return "Bücher im Besitzt anzeigen";
    }

    @Override
    public String description() {
        return "Zeit alle Bücher der Leseliste an, welche im Besitzt sind.";
    }
}
