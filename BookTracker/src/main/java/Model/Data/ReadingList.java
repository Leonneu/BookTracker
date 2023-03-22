package Model.Data;

import java.util.ArrayList;

public class ReadingList {
    ArrayList<ReadingListEntry> readingList;

    public ReadingList(ArrayList<ReadingListEntry> readingList) {
        this.readingList = readingList;
    }
    public void AddReadingListEntry(ReadingListEntry entry){
        readingList.add(entry);
    }

    public ArrayList<ReadingListEntry> GetUnownedBooks(){
        return (ArrayList<ReadingListEntry>) readingList.stream().filter(e->e.owned()==false).toList();
    }

    //TODO get 0 seems stupid
    public ReadingListEntry RemoveEntry(Book b){
        var toBeRemoved = readingList.stream().filter(e -> e.book().equals(b)).toList().get(0);
        readingList.remove(toBeRemoved);
        return toBeRemoved;
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
