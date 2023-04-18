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

    public ShowReadingListByTitle(Container container) {
        this.container = container;
    }

    @Override
    public State execute() {
        ReadingList readingList = container.getReadingList();
        String title = Input.promptMsg("Titel?");
        var result = readingList.searchByTitle(title);
        OutputBuilder output = new ListOutputBuilder();
        for (var e:result
        ) {
            output.append(e);
        }
        Output.showOutput(output.finalise());
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
