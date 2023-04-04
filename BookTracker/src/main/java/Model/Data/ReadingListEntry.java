package Model.Data;

import java.util.Objects;

public final class ReadingListEntry {
    private final Book book;
    private boolean owned;
    private final String comment;

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
        return book.toString() + "|" + owned + "|" + comment;
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

   public void acquireBook(){
        owned = true;
   }

}
