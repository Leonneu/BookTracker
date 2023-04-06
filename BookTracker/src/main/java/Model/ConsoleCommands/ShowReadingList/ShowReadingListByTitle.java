package Model.ConsoleCommands.ShowReadingList;

import IO.Input;
import IO.Output;
import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.Data.ReadingList;
import Model.State;

public class ShowReadingListByTitle implements ConsoleCommand {
    private final DIContainer container;

    public ShowReadingListByTitle(DIContainer container) {
        this.container = container;
    }

    @Override
    public State execute() {
        ReadingList readingList = container.getReadingList();
        String title = Input.promptMsg("Titel?");
        var result = readingList.searchByTitle(title);
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
        return "Filtern nach Titel";
    }

    @Override
    public String description() {
        return null;
    }
}
