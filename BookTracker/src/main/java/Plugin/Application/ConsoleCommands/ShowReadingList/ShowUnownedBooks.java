package Plugin.Application.ConsoleCommands.ShowReadingList;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.Model.ReadingList;
import Plugin.Application.State;
import Plugin.IO.Builder.OutputBuilder;
import Plugin.IO.Input;
import Plugin.IO.Output;

public class ShowUnownedBooks implements ConsoleCommand {
    private final Container container;
    private final OutputBuilder builder;

    public ShowUnownedBooks(Container container, OutputBuilder builder) {
        this.container = container;
        this.builder = builder;
    }

    @Override
    public State execute() {
        ReadingList readingList = container.getReadingList();
        var result = readingList.getUnownedBooks();
        builder.reset();
        for (var e : result
        ) {
            builder.append(e);
        }
        String output = builder.finalise();
        Output.showOutput(output);
        if (Input.promptUserIfSave()) {
            String path = Input.promptMsg("Pfad?");
            Output.saveToNewTextFile(path,output);
        }
        return State.SHOWREADINGLIST;
    }

    @Override
    public String name() {
        return "Unbessesene Bücher anzeigen";
    }

    @Override
    public String description() {
        return "Zeigt alle Bücher an, welche nicht im Besitzt sind. Hier kann eine Wunschliste erstellt werden.";
    }
}
