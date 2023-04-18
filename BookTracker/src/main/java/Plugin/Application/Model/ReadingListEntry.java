package Plugin.Application.Model;

public final class ReadingListEntry implements Entry{
    private final Book book;
    private String comment;
    private boolean owned;

    public ReadingListEntry(Book book, boolean owned, String comment) {
        this.book = book;
        this.owned = owned;
        this.comment = comment;
    }

    public ReadingListEntry(Book book) {
        this(book, false, "-");
    }

    @Override
    public String toString() {
        return String.format("%s|%10s|%-100s",book.toString(),(owned ? "Ja" : "Nein"),comment);
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Book book() {
        return book;
    }

    public boolean owned() {
        return owned;
    }

    public void acquireBook() {
        owned = true;
    }

}
