package Model.Data;

public record ReadingListEntry(Book book,boolean owned,String comment) {
    public ReadingListEntry(Book book, boolean owned, String comment) {
        this.book = book;
        this.owned = owned;
        this.comment = comment;
    }
    public ReadingListEntry(Book book) {
        this(book, false, null);
    }
    public ReadingListEntry(Book book, boolean owned) {
        this(book, owned, null);
    }

    @Override
    public String toString() {
        return book.toString()+"|"+owned+"|"+ comment;
    }
}
