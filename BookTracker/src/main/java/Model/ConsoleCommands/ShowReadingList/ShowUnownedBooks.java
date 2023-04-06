package Model.ConsoleCommands.ShowReadingList;

import IO.Input;
import IO.Output;
import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.Data.ReadingList;
import Model.Data.ReadingListEntry;
import Model.State;

import java.io.File;
import java.util.List;

public class ShowUnownedBooks implements ConsoleCommand {
    private final DIContainer container;

    public ShowUnownedBooks(DIContainer container) {
        this.container = container;
    }

    @Override
    public State execute() {
        ReadingList readingList = container.getReadingList();
        var result = readingList.getUnownedBooks();
        StringBuilder output = new StringBuilder();
        for (var e:result
        ) {
            output.append(e.toString()).append(Output.lineBreak);
        }
        Output.showHeaderReadingList();
        Output.showOutput(output.toString());
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
