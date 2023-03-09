package Model.ConsoleCommands.EditLibrary;

import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;

public class AddBookByWebSearch extends ConsoleCommand {
    public AddBookByWebSearch(DIContainer container) {
        super(container);
    }

    @Override
    public State execute() {
        return null;
    }

    @Override
    public String name() {
        return "By Web-search";
    }

    @Override
    public String description() {
        return null;
    }
}
