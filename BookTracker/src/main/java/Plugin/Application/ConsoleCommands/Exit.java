package Plugin.Application.ConsoleCommands;

import Plugin.IO.Input;
import Plugin.IO.Output;
import Plugin.Application.Container;
import Plugin.Application.State;

public class Exit implements ConsoleCommand {
    Container container;

    public Exit(Container container) {
        this.container = container;
    }

    @Override
    public State execute() {
        if(container.getPath() != null){
            if(Input.promptUserIfSave()) {
                String content = container.getReadingList().toString();
                content += "---"+Output.lineBreak;
                content += container.getReadingArchive().toString();
                content = content.replace(";",Output.lineBreak);
                Output.saveToTextFile(content,container.getPath());
            }
        }
        return State.EXIT;
    }

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public String description() {
        return "Exits the program.";
    }
}
