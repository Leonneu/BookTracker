package Plugin.Application.Model;

public record ReadingArchiveEntry(Book book, BookDateWrapper startedReading, BookDateWrapper finishedReading,
                                  String comment) implements Entry {

    @Override
    public String toString() {
        return String.format("%s|%10s|%10s|%-100s", book.toString(), startedReading, finishedReading, comment);
    }
}
