package Plugin.Application.ConsoleCommands.ShowStatistics;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.Model.BookDateWrapper;
import Plugin.Application.State;
import Plugin.IO.Input;
import Plugin.IO.Output;

import java.util.Arrays;
import java.util.List;

public class ReadingArchiveReport implements ConsoleCommand {
    Container container;
    public ReadingArchiveReport(Container container) {
        this.container = container;
    }

    @Override
    public State execute() {
        List<TypeOfReport> choices = Arrays.stream(TypeOfReport.values()).toList();
        var userInput = Input.promptUserForListChoice(choices);
        BookDateWrapper date;
        switch (userInput){
            case YEAR -> date = new BookDateWrapper(0,0,Integer.parseInt(Input.promptMsg("Für welches Jahr?")));
            case MONTH -> date = Input.promptUserForDate();
            default -> date = new BookDateWrapper();
        }
        ReadingArchiveStatisticGenerator statisticGenerator =  new ReadingArchiveStatisticGenerator(container.getReadingArchive(),date,userInput);
        Output.showOutput("");
        Output.showOutput(userInput +" Report:");
        Output.showOutput("Populärstes Genre: "+statisticGenerator.mostPopularGenre());
        Output.showOutput("Populärster Autor: "+statisticGenerator.mostPopularAuthor());
        Output.showOutput("Anzahl an gelesenen Büchern: "+statisticGenerator.booksReadInTimeSpan());
        Output.showOutput("Anzahl an gelesenen Seiten: "+statisticGenerator.pagesReadInTimeSpan());
        Output.showOutput("Durchschnittliche Anzahl an Seiten pro Tag: "+statisticGenerator.avgPagesInTimeSpan());
        Output.showOutput("Am schnellsten gelesenes Buch (Seiten/Tag): "+statisticGenerator.fastestRead().book().title());
        Output.showOutput("Am schnellsten gelesenens Buch (min. Tag): "+statisticGenerator.shortestRead().book().title());
        Output.showOutput("");

        return State.STATISTIC;
    }

    @Override
    public String name() {
        return "Lesearchiv Statistik anzeigen";
    }

    @Override
    public String description() {
        return "Zeigt die Statistiken zu den gelesenen Büchern in einem bestimmten Jahr an.";
    }
}
