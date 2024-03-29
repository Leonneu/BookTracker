package Plugin.Application.ConsoleCommands.ShowReadingArchive;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.Model.ReadingArchive;
import Plugin.Application.State;
import Plugin.IO.Builder.OutputBuilder;
import Plugin.IO.Input;
import Plugin.IO.Output;

public class ShowReadingArchiveByAuthor implements ConsoleCommand {
    Container container;
    OutputBuilder builder;

    public ShowReadingArchiveByAuthor(Container container, OutputBuilder builder) {
        this.builder = builder;
        this.container = container;
    }

    @Override
    public State execute() {
        ReadingArchive readingArchive = container.getReadingArchive();
        String author = Input.promptMsg("Autor?");
        var result = readingArchive.searchByAuthor(author);
        builder.reset();
        for (var e : result
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
        return "Zeigt alle Bücher im Lesearchive an die von dem spezifiziertem Autor sind.";
    }
}
