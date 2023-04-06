package Model.ConsoleCommands.ShowReadingArchive;

import IO.Input;
import IO.Output;
import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.Data.ReadingArchive;
import Model.State;

public class ShowReadingArchiveByAuthor implements ConsoleCommand {
    DIContainer container;

    public ShowReadingArchiveByAuthor(DIContainer container) {
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
