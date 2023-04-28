package Plugin.Application.Model;

import java.util.ArrayList;
import java.util.List;


//Make one class with two lists?
//Make one class one list and DB like fields?
//Make two classes? Single Responsibility
public class ReadingArchive {
    private final ArrayList<ReadingArchiveEntry> archive;

    public ReadingArchive(ArrayList<ReadingArchiveEntry> archive) {
        this.archive = archive;
    }

    public void AddEntry(ReadingArchiveEntry entry) {
        archive.add(entry);
    }

    public List<ReadingArchiveEntry> searchByAuthor(String author) {
        return archive.stream().filter(e -> e.book().author().contains(author)).toList();
    }

    public List<ReadingArchiveEntry> searchByTitle(String title) {
        return archive.stream().filter(e -> e.book().title().contains(title)).toList();
    }

    public List<ReadingArchiveEntry> getArchiveAsList() {
        return archive;
    }

    public boolean RemoveEntry(Book b) {
        return archive.remove(archive.stream().filter(e -> e.book().equals(b)));
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String valueSeparation = ";";
        for (var e : archive
        ) {
            result.append(e.toString()).append(valueSeparation);
        }
        return result.toString();
    }

    public List<ReadingArchiveEntry> searchByYear(int year) {
        return archive.stream().filter(e -> e.finishedReading().year() == year).toList();
    }

    public List<ReadingArchiveEntry> searchByMonth(BookDateWrapper targetDate) {
        return archive.stream().filter(e -> (e.finishedReading().year() == targetDate.year() && e.finishedReading().month() == targetDate.month())).toList();
    }
}
