package Model.Data;

public record ReadingArchiveEntry(Book book,Date startedReading,Date finishedReading,String Comment) {
    public ReadingArchiveEntry(Book book, Date startedReading, Date finishedReading, String Comment) {
        this.book = book;
        this.startedReading = startedReading;
        this.finishedReading = finishedReading;
        this.Comment = Comment;
    }

    public ReadingArchiveEntry(Book book, Date finishedReading) {
        this(book, null, finishedReading, null);
    }

    public ReadingArchiveEntry(Book book, Date startedReading, Date finishedReading) {

        this(book, startedReading, finishedReading, null);
    }
}
