package Plugin.Application.ConsoleCommands.ShowReadingArchive;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.Model.ReadingArchive;
import Plugin.Application.State;
import Plugin.IO.Builder.ArchiveOutputBuilder;
import Plugin.IO.Builder.OutputBuilder;
import Plugin.IO.Input;
import Plugin.IO.Output;

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
        OutputBuilder builder = new ArchiveOutputBuilder();
        for (var e:result
        ) {
            builder.append(e);
        }
        Output.showOutput(builder.finalise());
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
