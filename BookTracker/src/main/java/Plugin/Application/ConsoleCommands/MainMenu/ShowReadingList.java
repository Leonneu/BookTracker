package Plugin.Application.ConsoleCommands.MainMenu;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.State;
import Plugin.IO.Builder.OutputBuilder;
import Plugin.IO.Output;

public class ShowReadingList implements ConsoleCommand {
    Container container;
    OutputBuilder builder;

    public ShowReadingList(Container container, OutputBuilder builder) {
        this.container = container;
        this.builder = builder;
    }

    @Override
    public State execute() {
        builder.reset();
        for (var e : container.getReadingList().getReadingListAsList()
        ) {
            builder.append(e);
        }
        Output.showOutput(builder.finalise());
        return State.SHOWREADINGLIST;
    }

    @Override
    public String name() {
        return "Leseliste anzeigen";
    }

    @Override
    public String description() {
        return "Zeigt die Leseliste an";
    }
}
