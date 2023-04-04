package Model.Data;

import java.util.Objects;

public final class ReadingListEntry {
    private final Book book;
    private final String comment;
    private boolean owned;

    public ReadingListEntry(Book book, boolean owned, String comment) {
        this.book = book;
        this.owned = owned;
        this.comment = comment;
    }

    public ReadingListEntry(Book book) {
        this(book, false, "-");
    }

    public ReadingListEntry(Book book, boolean owned) {
        this(book, owned, "-");
    }

    @Override
    public String toString() {
        return String.format("%s|%10s|%-100s",book.toString(),(owned ? "Ja" : "Nein"),comment);
    }

    public Book book() {
        return book;
    }

    public boolean owned() {
        return owned;
    }

    public String comment() {
        return comment;
    }

    public void acquireBook() {
        owned = true;
    }

}
