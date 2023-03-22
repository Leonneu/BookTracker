package Model.Data;

public record ReadingArchiveEntry(Book book, Date startedReading, Date finishedReading, boolean owned, String comment) {
    public ReadingArchiveEntry(Book book, Date startedReading, Date finishedReading, boolean owned, String comment) {
        this.book = book;
        this.startedReading = startedReading;
        this.finishedReading = finishedReading;
        this.owned = owned;
        this.comment = comment;
    }

    public ReadingArchiveEntry(Book book, Date finishedReading, boolean owned) {
        this(book, null, finishedReading, owned, null);
    }

    public ReadingArchiveEntry(Book book, Date startedReading, Date finishedReading, boolean owned) {

        this(book, startedReading, finishedReading, owned, null);
    }

    //TODO Stringbuilder
    @Override
    public String toString() {
        return book.toString()+"|"+startedReading.toString()+"|"+finishedReading.toString()+"|"+owned+"|"+comment;    }
}
