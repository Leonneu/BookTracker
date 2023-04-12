package Plugin.Application.ConsoleCommands.Init;

import Plugin.Application.Container;
import Plugin.Application.State;
import Plugin.IO.Input;
import Plugin.IO.Output;
import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Model.ReadingArchive;
import Plugin.Application.Model.ReadingList;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class NewLibrary implements ConsoleCommand {
    private final Container container;

    public NewLibrary(Container container) {
        this.container = container;
    }

    @Override
    public State execute()  {
        String filename = Input.promptMsg("Bibliothekname?");
        String path = System.getProperty("user.dir")+"\\"+filename;

        File f = new File(path);
        try {
            f.createNewFile();
            Output.showOutput("Wird gespeichert unter: "+path);
        }catch (IOException e){
            Output.showOutput(e.getMessage());
            return State.INIT;
        }

        container.setPath(new File(path));
        container.setReadingList(new ReadingList(new ArrayList<>()));
        container.setReadingArchive(new ReadingArchive(new ArrayList<>()));

        return State.MAIN;
    }

    @Override
    public String name() {
        return "Neue Bibliothek anlegen";
    }

    @Override
    public String description() {
        return "Legt eine neue Bibliothek an";
    }
}
