package Plugin.Application.ConsoleCommands.MainMenu;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.State;
import Plugin.IO.Builder.ArchiveOutputBuilder;
import Plugin.IO.Builder.OutputBuilder;
import Plugin.IO.Output;

public class ShowReadingArchive implements ConsoleCommand {
    private final Container container;
    public ShowReadingArchive(Container container) {
        this.container = container;
    }

    @Override
    public State execute() {
        OutputBuilder builder = new ArchiveOutputBuilder();
        for (var e:container.GetReadingArchive().getArchiveAsList()
             ) {
            builder.append(e);
        }
        Output.showOutput(builder.finalise());
        return State.SHOWREADINGARCHIVE;
    }

    @Override
    public String name() {
        return "Lesearchive anzeigen";
    }

    @Override
    public String description() {
        return "Shows all the Books currently in the Library";
    }
}
