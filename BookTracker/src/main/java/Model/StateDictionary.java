package Model;

import Model.ConsoleCommands.*;
import Model.ConsoleCommands.EditLibrary.*;
import Model.ConsoleCommands.MainMenu.*;
import Model.Data.DIContainer;

import java.util.HashMap;
import java.util.Map;

public class StateDictionary {
    private Map<State, ConsoleCommand[]> dic = new HashMap<>();

    public StateDictionary(DIContainer container) {
        dic.put(State.INIT, new ConsoleCommand[]{
                new LoadLibrary(container),
                new Exit()
        });
        dic.put(State.MAIN, new ConsoleCommand[]{
                new ShowLibrary(container),
                new EditLibrary(container),
                new ShowWishList(container),
                new EditWishList(container),
                new ShowStatistics(container),
                new Exit()
        });
        dic.put(State.EDITLIBRARY, new ConsoleCommand[]{
                new AddBook(container),
                new DeleteBook(container),
                new Cancel()
        });
        dic.put(State.EDITWISHLIST, new ConsoleCommand[]{
                new AddBook(container),
                new DeleteBook(container),
                new Cancel()
        });
        dic.put(State.EXIT, new ConsoleCommand[]{
        });
        dic.put(State.ADDBOOKTOLIBRARY, new ConsoleCommand[]{
                new AddBookFromWishlist(container),
                new AddBookByWebSearch(container),
                new AddBookManually(container),
                new Cancel()});
    }

    public ConsoleCommand[] GetOptions(State appState) {
        return dic.get(appState);
    }
}
