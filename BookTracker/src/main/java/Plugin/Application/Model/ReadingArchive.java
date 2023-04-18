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

    //TODO more sophisticated matching of searchstring, Regex?
    public List<ReadingArchiveEntry> searchByAuthor(String author) {
        return archive.stream().filter(e -> e.book().Author().contains(author)).toList();
    }

    //TODO more sophisticated matching of searchstring, Regex?
    public List<ReadingArchiveEntry> searchByTitle(String title) {
        return archive.stream().filter(e -> e.book().Title().contains(title)).toList();
    }
    public List<ReadingArchiveEntry> getArchiveAsList(){
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
}
