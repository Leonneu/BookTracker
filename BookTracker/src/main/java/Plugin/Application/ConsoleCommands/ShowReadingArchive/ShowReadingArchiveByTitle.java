package Plugin.Application.ConsoleCommands.ShowReadingArchive;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.Model.ReadingArchive;
import Plugin.Application.State;
import Plugin.IO.Builder.ArchiveOutputBuilder;
import Plugin.IO.Builder.OutputBuilder;
import Plugin.IO.Input;
import Plugin.IO.Output;

public class ShowReadingArchiveByTitle implements ConsoleCommand {
    Container container;

    public ShowReadingArchiveByTitle(Container container) {
        this.container = container;
    }

    @Override
    public State execute() {
        ReadingArchive readingArchive = container.getReadingArchive();
        String title = Input.promptMsg("Titel?");
        var result = readingArchive.searchByTitle(title);
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
        return "Filtern nach Titel";
    }

    @Override
    public String description() {
        return null;
    }
}
