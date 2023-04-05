package Model.ConsoleCommands.ShowReadingList;

import IO.Input;
import IO.Output;
import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.Data.ReadingList;
import Model.State;

public class ShowReadingListByAuthor implements ConsoleCommand {
    private final DIContainer container;

    public ShowReadingListByAuthor(DIContainer container) {
        this.container = container;
    }

    @Override
    public State execute() {
        ReadingList readingList = container.getReadingList();
        String title = Input.promptMsg("Autor?");
        var result = readingList.searchByAuthor(title);
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
        return "Filter nach Autor";
    }

    @Override
    public String description() {
        return null;
    }
}
