package Model.ConsoleCommands;

import IO.Input;
import IO.Output;
import Model.Data.DIContainer;
import Model.State;

public class Exit implements ConsoleCommand {
    DIContainer container;

    public Exit(DIContainer container) {
        this.container = container;
    }

    @Override
    public State execute() {
        String answer = Input.promptMsg("Änderungen speichern? (Y/N)").toLowerCase();
        if(answer.startsWith("j") || answer.startsWith("y")) {
            String content = container.getReadingList().toString();
            content += "---"+Output.lineBreak;
            content += container.GetReadingArchive().toString();
            content = content.replace(";",Output.lineBreak);
            Output.saveToTextFile(content,container.getPath());
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
