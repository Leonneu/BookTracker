package Model;

import Model.ConsoleCommands.*;
import Model.ConsoleCommands.EditReadingList.*;
import Model.ConsoleCommands.MainMenu.*;
import Model.Data.DIContainer;

import java.util.HashMap;
import java.util.Map;

public class StateDictionary {
    private Map<State, ConsoleCommand[]> dic = new HashMap<>();

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
        dic.put(State.EDITREADINGARCHIVE, new ConsoleCommand[]{
                new AddBookFromReadingList(container),
                new AcquireBook(container),
                new DeleteBook(container),
                new Cancel()
        });
        dic.put(State.EDITREADINGLIST, new ConsoleCommand[]{
                new AddBookToReadingList(container),
                new AcquireBook(container),
                new DeleteBook(container),
                new Cancel()
        });
        dic.put(State.EXIT, new ConsoleCommand[]{
        });
        dic.put(State.ADDBOOKTOREADINGLIST, new ConsoleCommand[]{
                new AddBookByWebSearch(container),
                new AddBookManually(container),
                new Cancel()});
    }

    public ConsoleCommand[] GetOptions(State appState) {
        return dic.get(appState);
    }
}
