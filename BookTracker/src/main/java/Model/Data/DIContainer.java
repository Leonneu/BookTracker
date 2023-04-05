package Model.Data;

import java.io.File;

public final class DIContainer {
    private ReadingList readingList;
    private ReadingArchive readingArchive;
    private File path;

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

    public ReadingList getReadingList() {
        return readingList;
    }

    public void setReadingList(ReadingList readingList) {
        this.readingList=readingList;
    }

    public File getPath() {
        return path;
    }

    public void setPath(File path) {
        this.path = path;
    }
}
