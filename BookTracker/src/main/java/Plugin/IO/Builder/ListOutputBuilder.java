package Plugin.IO.Builder;

import Plugin.Application.Model.Entry;
import Plugin.IO.Output;

import java.util.List;

public class ListOutputBuilder implements OutputBuilder{
    final static String lineSeparator = Output.lineBreak;
    final static String separator = "-".repeat(170);
    final static String header = "%-20s|%-20s|%-10s|%-7s|%-60s|%-10s|%-100s".formatted("Titel", "Autor", "Seitenzahl", "Sprache", "Genre","In Besitzt","Notiz");
    StringBuilder result;
    public ListOutputBuilder() {
        result = new StringBuilder(header).append(lineSeparator).append(separator).append(lineSeparator);
    }

    @Override
    public void append(Entry entry) {
        result.append(entry.toString()).append(lineSeparator);
    }

    @Override
    public void append(List<Entry> entryList) {
        for (var e: entryList
        ) {
            result.append(e).append(lineSeparator);
        }
    }

    @Override
    public String finalise() {
        result.append(separator);
        return result.toString();
    }
}
