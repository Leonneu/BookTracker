package Model;

import Model.ConsoleCommands.*;
import Model.ConsoleCommands.EditReadingArchive.AddReadingArchiveEntryManually;
import Model.ConsoleCommands.EditReadingArchive.AddReadingListEntryToReadingArchive;
import Model.ConsoleCommands.EditReadingList.*;
import Model.ConsoleCommands.MainMenu.*;
import Model.ConsoleCommands.ShowReadingList.ShowReadingListByAuthor;
import Model.ConsoleCommands.ShowReadingList.ShowReadingListByTitle;
import Model.ConsoleCommands.ShowReadingArchive.ShowReadingArchiveByAuthor;
import Model.ConsoleCommands.ShowReadingArchive.ShowReadingArchiveByTitle;
import Model.Data.DIContainer;

import java.util.HashMap;
import java.util.Map;

public class StateDictionary {
    private final Map<State, ConsoleCommand[]> dic = new HashMap<>();

    public StateDictionary(DIContainer container) {
        dic.put(State.INIT, new ConsoleCommand[]{
                new LoadLibrary(container),
                new Exit(container)
        });
        dic.put(State.MAIN, new ConsoleCommand[]{
                new ShowReadingArchive(container),
                new EditReadingArchive(container),
                new ShowReadingList(container),
                new EditReadingList(container),
                new ShowStatistics(container),
                new Exit(container)
        });
        dic.put(State.SHOWREADINGARCHIVE,new ConsoleCommand[]{
                new ShowReadingArchiveByTitle(container),
                new ShowReadingArchiveByAuthor(container),
                new Cancel()
        });
        dic.put(State.EDITREADINGARCHIVE, new ConsoleCommand[]{
                new AddReadingListEntryToReadingArchive(container),
                new AddReadingArchiveEntryManually(container),
                new Cancel()
        });
        dic.put(State.SHOWREADINGLIST,new ConsoleCommand[]{
                new ShowReadingListByTitle(container),
                new ShowReadingListByAuthor(container),
                new Cancel()
        });
        dic.put(State.EDITREADINGLIST, new ConsoleCommand[]{
                new AddReadingListEntryToReadingList(container),
                new AcquireBook(container),
                new RemoveBookFromReadingList(container),
                new AttachComment(container),
                new Cancel()
        });
        dic.put(State.ADDBOOKTOREADINGLIST, new ConsoleCommand[]{
                new AddReadingListEntryByWebSearch(container),
                new AddReadingListEntryManually(container),
                new Cancel()});
        dic.put(State.EXIT, new ConsoleCommand[]{
        });
    }

    public ConsoleCommand[] GetOptions(State appState) {
        return dic.get(appState);
    }
}
