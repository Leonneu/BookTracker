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

    public ReadingArchiveEntry(Book book, Date finishedReading) {
        this(book, null, finishedReading, null);
    }

    public ReadingArchiveEntry(Book book, Date startedReading, Date finishedReading) {

        this(book, startedReading, finishedReading,  null);
    }

    //TODO Stringbuilder
    @Override
    public String toString() {
        return String.format("%s|%10s|%10s|%-100s",book.toString(),startedReading,finishedReading,comment);
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
