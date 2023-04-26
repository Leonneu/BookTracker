package Plugin.Application.ConsoleCommands.ShowStatistics;

import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.State;
import Plugin.IO.Output;

public class ReadingListReport implements ConsoleCommand {
    Container container;

    public ReadingListReport(Container container) {
        this.container = container;
    }

    @Override
    public State execute() {
        ReadingListStatisticGenerator statisticGenerator = new ReadingListStatisticGenerator(container.getReadingList());
        Output.showOutput("");
        Output.showOutput("Populärster Autor: " + statisticGenerator.mostPopularAuthor());
        Output.showOutput("Populärstes Genre: " + statisticGenerator.mostPopularGenre().name());
        Output.showOutput("Bücher auf der Leseliste: " + statisticGenerator.numberOfBooksOnReadingList());
        Output.showOutput("Davon in Besitzt: " + doubleToPercent(statisticGenerator.percentOfBooksOwned()));
        Output.showOutput("Durchschnittliche Buchlänge: " + statisticGenerator.avgPageCount() + " Seiten");
        Output.showOutput("Gesamte Anzahl an zu lesenden Seiten: " + statisticGenerator.pagesToRead());
        Output.showOutput("");
        return State.STATISTIC;
    }

    private String doubleToPercent(double num) {
        double percent = num * 100;
        return String.format("%.2f%%", percent);
    }

    @Override
    public String name() {
        return "Leseliste Statistik anzeigen";
    }

    @Override
    public String description() {
        return "Zeigt eine Analyse der Leseliste an.";
    }
}
