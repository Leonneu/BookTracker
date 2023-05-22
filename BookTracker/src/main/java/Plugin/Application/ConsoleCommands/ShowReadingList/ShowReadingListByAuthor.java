package Plugin.Application.ConsoleCommands.ShowReadingList;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.Model.ReadingList;
import Plugin.Application.State;
import Plugin.IO.Builder.OutputBuilder;
import Plugin.IO.Input;
import Plugin.IO.Output;

public class ShowReadingListByAuthor implements ConsoleCommand {
    private final Container container;
    private final OutputBuilder builder;

    public ShowReadingListByAuthor(Container container, OutputBuilder builder) {
        this.container = container;
        this.builder = builder;
    }

    @Override
    public State execute() {
        ReadingList readingList = container.getReadingList();
        String author = Input.promptMsg("Autor?");
        var result = readingList.searchByAuthor(author);
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
        return "Filtern nach Autor";
    }

    @Override
    public String description() {
        return "Zeigt alle Bücher in der Leseliste an, welche von dem spezifizirten Autor sind.";
    }
}
