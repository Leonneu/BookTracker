package Plugin.Application.Model;

import java.util.ArrayList;
import java.util.List;

public class ReadingList {
    ArrayList<ReadingListEntry> readingList;

    public ReadingList(ArrayList<ReadingListEntry> readingList) {
        this.readingList = readingList;
    }
    public void addReadingListEntry(ReadingListEntry entry){
        readingList.add(entry);
    }

    public List<ReadingListEntry> getUnownedBooks(){
        return readingList.stream().filter(e-> !e.owned()).toList();
    }

    public List<ReadingListEntry> getOwnedBooks(){
        return readingList.stream().filter(ReadingListEntry::owned).toList();
    }

    //TODO Regex
    public List<ReadingListEntry> searchByTitle(String title) {
        return readingList.stream().filter(e -> e.book().Title().toLowerCase().contains(title.toLowerCase())).toList();
    }

    public List<ReadingListEntry> searchByAuthor(String author) {
        return readingList.stream().filter(e -> e.book().Author().toLowerCase().contains(author.toLowerCase())).toList();
    }

    public void removeEntry(ReadingListEntry entryToRemove){
        readingList.remove(entryToRemove);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (ReadingListEntry e:readingList
             ) {
            result.append(e.toString()).append(";");
        }
        return result.toString();
    }
}
