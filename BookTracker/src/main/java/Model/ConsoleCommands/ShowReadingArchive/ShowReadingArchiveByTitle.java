package Model.ConsoleCommands.ShowReadingArchive;

import IO.Input;
import IO.Output;
import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.Data.ReadingArchive;
import Model.State;

public class ShowReadingArchiveByTitle implements ConsoleCommand {
    DIContainer container;

    public ShowReadingArchiveByTitle(DIContainer container) {
        this.container = container;
    }

    @Override
    public State execute() {
        ReadingArchive readingArchive = container.GetReadingArchive();
        String title = Input.promptMsg("Titel?");
        var result = readingArchive.searchByTitle(title);
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
        return "Filtern nach Titel";
    }

    @Override
    public String description() {
        return null;
    }
}
