package Model.Data;

public record ReadingListEntry(Book book,boolean owned,String Comment) {
    public ReadingListEntry(Book book, boolean owned, String Comment) {
        this.book = book;
        this.owned = owned;
        this.Comment = Comment;
    }
    public ReadingListEntry(Book book) {
        this(book, false, null);
    }
    public ReadingListEntry(Book book, boolean owned) {
        this(book, owned, null);
    }
}
