package Plugin.Application.ConsoleCommands.ShowReadingList;

import Plugin.IO.Builder.ListOutputBuilder;
import Plugin.IO.Builder.OutputBuilder;
import Plugin.IO.Input;
import Plugin.IO.Output;
import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.Model.ReadingList;
import Plugin.Application.State;

public class ShowReadingListByTitle implements ConsoleCommand {
    private final Container container;
    private final OutputBuilder builder;

    public ShowReadingListByTitle(Container container, OutputBuilder builder) {
        this.container = container;
        this.builder = builder;
    }

    @Override
    public State execute() {
        ReadingList readingList = container.getReadingList();
        String title = Input.promptMsg("Titel?");
        var result = readingList.searchByTitle(title);
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
        return "Filtern nach Titel";
    }

    @Override
    public String description() {
        return null;
    }
}
