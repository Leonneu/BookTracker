package Plugin.Application.ConsoleCommands.ShowReadingList;

import Plugin.IO.Builder.ListOutputBuilder;
import Plugin.IO.Builder.OutputBuilder;
import Plugin.IO.Input;
import Plugin.IO.Output;
import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.Model.ReadingList;
import Plugin.Application.Model.ReadingListEntry;
import Plugin.Application.State;

import java.io.File;
import java.util.List;

public class ShowUnownedBooks implements ConsoleCommand {
    private final Container container;

    public ShowUnownedBooks(Container container) {
        this.container = container;
    }

    @Override
    public State execute() {
        ReadingList readingList = container.getReadingList();
        var result = readingList.getUnownedBooks();
        OutputBuilder builder = new ListOutputBuilder();
        for (var e:result
        ) {
            builder.append(e);
        }
        Output.showOutput(builder.finalise());
        String ans = Input.promptMsg("Als Wunschliste speichern? (Y/N)").toLowerCase();
        if(ans.startsWith("j")||ans.startsWith("y")){
            try {
                String path = Input.promptMsg("Pfad?");
                File f = new File(path+"\\Wunschliste.txt");
                if(f.createNewFile()){
                    Output.saveToTextFile(formatWishListOutput(result),f);
                }
            }catch (Exception e){
                Output.showOutput("Fehler beim Speichern: "+e.getMessage());
            }
            Output.showOutput("Datei erfolgreich gespeichert!");
        }

        return State.SHOWREADINGLIST;
    }

    private String formatWishListOutput(List<ReadingListEntry> content) {
        StringBuilder result = new StringBuilder();
        for (var e:content
             ) {
            result.append(e.toString()).append(Output.lineBreak);
        }
        return result.toString();
    }

    @Override
    public String name() {
        return "Unbessesene Bücher anzeigen";
    }

    @Override
    public String description() {
        return null;
    }
}
