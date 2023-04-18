package Plugin.Application.ConsoleCommands.ShowReadingList;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.Model.ReadingList;
import Plugin.Application.State;
import Plugin.IO.Builder.ListOutputBuilder;
import Plugin.IO.Builder.OutputBuilder;
import Plugin.IO.Input;
import Plugin.IO.Output;

public class ShowReadingListByAuthor implements ConsoleCommand {
    private final Container container;

    public ShowReadingListByAuthor(Container container) {
        this.container = container;
    }

    @Override
    public State execute() {
        ReadingList readingList = container.getReadingList();
        String author = Input.promptMsg("Autor?");
        var result = readingList.searchByAuthor(author);
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
        return "Filtern nach Autor";
    }

    @Override
    public String description() {
        return null;
    }
}
