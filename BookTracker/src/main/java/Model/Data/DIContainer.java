package Model.Data;

public final class DIContainer {
    private ReadingList readingList;
    private ReadingArchive readingArchive;

    public DIContainer(
            ReadingList readingList,
            ReadingArchive readingArchive

    ) {
        this.readingArchive = readingArchive;
        this.readingList =readingList;
    }

    public ReadingArchive GetReadingArchive() {
        return readingArchive;
    }
    public void SetReadingArchive(ReadingArchive readingArchive) {
        this.readingArchive = readingArchive;
    }

    public ReadingList GetReadingList() {
        return readingList;
    }

    public void SetReadingList(ReadingList readingList) {
        this.readingList=readingList;
    }

}
