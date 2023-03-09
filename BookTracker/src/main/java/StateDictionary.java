import StateLogic.*;

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
                new ShowLibrary(container),
                new EditLibrary(container),
                new ShowWishList(container),
                new EditWishList(container),
                new ShowStatistics(container),
                new Exit(container)
        });
        dic.put(State.EDITLIBRARY, new ConsoleCommand[]{
                new AddBook(container),
                new DeleteBook(container),
                new Cancel(container)
        });
        dic.put(State.EDITWISHLIST, new ConsoleCommand[]{
                new AddBook(container),
                new DeleteBook(container),
                new Cancel(container)
        });
        dic.put(State.EXIT, new ConsoleCommand[]{
        });
    }

    public ConsoleCommand[] GetOptions(State appState) {
        return dic.get(appState);
    }
}
