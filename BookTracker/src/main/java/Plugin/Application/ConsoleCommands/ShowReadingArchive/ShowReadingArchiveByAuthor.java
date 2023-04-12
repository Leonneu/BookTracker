package Plugin.Application.ConsoleCommands.ShowReadingArchive;

import Plugin.IO.Input;
import Plugin.IO.Output;
import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.Model.ReadingArchive;
import Plugin.Application.State;

public class ShowReadingArchiveByAuthor implements ConsoleCommand {
    Container container;

    public ShowReadingArchiveByAuthor(Container container) {
        this.container = container;
    }

    @Override
    public State execute() {
        ReadingArchive readingArchive = container.GetReadingArchive();
        String author = Input.promptMsg("Autor?");
        var result = readingArchive.searchByAuthor(author);
        StringBuilder output = new StringBuilder();
        for (var e:result
        ) {
            output.append(e.toString()).append(Output.lineBreak);
        }
        Output.showHeaderReadingArchive();
        Output.showOutput(output.toString());
        return State.SHOWREADINGARCHIVE;
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
