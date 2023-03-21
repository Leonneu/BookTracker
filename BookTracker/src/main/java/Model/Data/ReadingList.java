package Model.Data;

import java.util.ArrayList;

public class ReadingList {
    ArrayList<ReadingListEntry> readingList;

    public ReadingList() {
        this.readingList = new ArrayList<>();
    }
    public void LoadReadingList(ArrayList<ReadingListEntry> readingList){
        this.readingList = readingList;
    }
    public void AddReadingListEntry(ReadingListEntry entry){
        readingList.add(entry);
    }

    public ArrayList<ReadingListEntry> GetUnownedBooks(){
        return (ArrayList<ReadingListEntry>) readingList.stream().filter(e->e.owned()==false).toList();
    }
}
