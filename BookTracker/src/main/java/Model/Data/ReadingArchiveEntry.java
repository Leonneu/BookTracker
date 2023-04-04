package Model.Data;

import java.util.Objects;

public final class ReadingArchiveEntry {
    private final Book book;
    private final Date startedReading;
    private final Date finishedReading;
    private final String comment;

    public ReadingArchiveEntry(Book book, Date startedReading, Date finishedReading, String comment) {
        this.book = book;
        this.startedReading = startedReading;
        this.finishedReading = finishedReading;
        this.comment = comment;
    }

    public ReadingArchiveEntry(Book book, Date finishedReading, boolean owned) {
        this(book, null, finishedReading, null);
    }

    public ReadingArchiveEntry(Book book, Date startedReading, Date finishedReading) {

        this(book, startedReading, finishedReading,  null);
    }

    //TODO Stringbuilder
    @Override
    public String toString() {
        return book.toString() + "|" + startedReading.toString() + "|" + finishedReading.toString() + "|"  + comment;
    }

    public Book book() {
        return book;
    }

    public Date startedReading() {
        return startedReading;
    }

    public Date finishedReading() {
        return finishedReading;
    }

    public String comment() {
        return comment;
    }

    public void updateComment() {

    }
}
