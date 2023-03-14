package Model.ConsoleCommands.MainMenu;

import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;

public class ShowWishList implements ConsoleCommand {
    DIContainer container;
    public ShowWishList(DIContainer container) {
        this.container=container;
    }

    @Override
    public State execute() {
        return null;
    }

    @Override
    public String name() {
        return "Wunschliste anzeigen";
    }

    @Override
    public String description() {
        return "Zeigt die Wunschliste an";
    }
}
