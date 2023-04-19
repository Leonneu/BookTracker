package Plugin.Application;

import Plugin.Application.Model.ReadingArchive;
import Plugin.Application.Model.ReadingList;

import java.io.File;

public final class Container {
    private ReadingList readingList;
    private ReadingArchive readingArchive;
    private File path;

    public Container(
            ReadingList readingList,
            ReadingArchive readingArchive

    ) {
        this.readingArchive = readingArchive;
        this.readingList = readingList;
    }

    public ReadingArchive getReadingArchive() {
        return readingArchive;
    }

    public void setReadingArchive(ReadingArchive readingArchive) {
        this.readingArchive = readingArchive;
    }

    public ReadingList getReadingList() {
        return readingList;
    }

    public void setReadingList(ReadingList readingList) {
        this.readingList = readingList;
    }

    public File getPath() {
        return path;
    }

    public void setPath(File path) {
        this.path = path;
    }
}
