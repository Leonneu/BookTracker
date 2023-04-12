package Plugin.Application.ConsoleCommands.ShowReadingList;

import Plugin.IO.Input;
import Plugin.IO.Output;
import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.Model.ReadingList;
import Plugin.Application.State;

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
        return "Filtern nach Autor";
    }

    @Override
    public String description() {
        return null;
    }
}
