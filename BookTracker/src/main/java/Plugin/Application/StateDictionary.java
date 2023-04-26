package Plugin.Application;

import Plugin.Application.ConsoleCommands.Cancel;
import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.ConsoleCommands.EditReadingArchive.AddReadingArchiveEntryManually;
import Plugin.Application.ConsoleCommands.EditReadingArchive.AddReadingListEntryToReadingArchive;
import Plugin.Application.ConsoleCommands.EditReadingList.*;
import Plugin.Application.ConsoleCommands.Exit;
import Plugin.Application.ConsoleCommands.Init.LoadLibrary;
import Plugin.Application.ConsoleCommands.Init.NewLibrary;
import Plugin.Application.ConsoleCommands.MainMenu.*;
import Plugin.Application.ConsoleCommands.ShowReadingArchive.ShowReadingArchiveByAuthor;
import Plugin.Application.ConsoleCommands.ShowReadingArchive.ShowReadingArchiveByTitle;
import Plugin.Application.ConsoleCommands.ShowReadingList.ShowOwnedBooks;
import Plugin.Application.ConsoleCommands.ShowReadingList.ShowReadingListByAuthor;
import Plugin.Application.ConsoleCommands.ShowReadingList.ShowReadingListByTitle;
import Plugin.Application.ConsoleCommands.ShowReadingList.ShowUnownedBooks;
import Plugin.Application.ConsoleCommands.ShowStatistics.ReadingListReport;
import Plugin.Application.ConsoleCommands.ShowStatistics.ReadingArchiveReport;
import Plugin.GoogleBooksWebApi;
import Plugin.IO.Builder.ArchiveOutputBuilder;
import Plugin.IO.Builder.ListOutputBuilder;
import Plugin.JsonParser;

import java.util.HashMap;
import java.util.Map;

public class StateDictionary {
    private final Map<State, ConsoleCommand[]> dic = new HashMap<>();

    public StateDictionary(Container container) {
        dic.put(State.INIT, new ConsoleCommand[]{
                new LoadLibrary(container),
                new NewLibrary(container),
                new Exit(container)
        });
        dic.put(State.MAIN, new ConsoleCommand[]{
                new ShowReadingArchive(container, new ArchiveOutputBuilder()),
                new EditReadingArchive(),
                new ShowReadingList(container, new ListOutputBuilder()),
                new EditReadingList(),
                new ShowStatistics(container),
                new Exit(container)
        });
        dic.put(State.SHOWREADINGARCHIVE, new ConsoleCommand[]{
                new ShowReadingArchiveByTitle(container,new ArchiveOutputBuilder()),
                new ShowReadingArchiveByAuthor(container,new ArchiveOutputBuilder()),
                new Cancel()
        });
        dic.put(State.EDITREADINGARCHIVE, new ConsoleCommand[]{
                new AddReadingListEntryToReadingArchive(container),
                new AddReadingArchiveEntryManually(container),
                new Cancel()
        });
        dic.put(State.SHOWREADINGLIST, new ConsoleCommand[]{
                new ShowReadingListByTitle(container, new ListOutputBuilder()),
                new ShowReadingListByAuthor(container, new ListOutputBuilder()),
                new ShowUnownedBooks(container, new ListOutputBuilder()),
                new ShowOwnedBooks(container, new ListOutputBuilder()),
                new Cancel()
        });
        dic.put(State.EDITREADINGLIST, new ConsoleCommand[]{
                new AddReadingListEntryToReadingList(),
                new AcquireBook(container),
                new RemoveBookFromReadingList(container),
                new AttachComment(container),
                new Cancel()
        });
        dic.put(State.ADDBOOKTOREADINGLIST, new ConsoleCommand[]{
                new AddReadingListEntryByWebSearch(container, new GoogleBooksWebApi(new JsonParser())),
                new AddReadingListEntryManually(container),
                new Cancel()});
        dic.put(State.STATISTIC, new ConsoleCommand[]{
                new ReadingArchiveReport(container),
                new ReadingListReport(container),
                new Cancel()
        });
        dic.put(State.EXIT, new ConsoleCommand[]{
        });
    }

    public ConsoleCommand[] GetOptions(State appState) {
        return dic.get(appState);
    }
}
