package Model.Data;

import java.util.ArrayList;
import java.util.stream.Collectors;


//Make one class with two lists?
//Make one class one list and DB like fields?
//Make two classes? Single Responsibility
public class ReadingArchive {
    private ArrayList<ReadingArchiveEntry> archive;
    public ReadingArchive() {
        archive = new ArrayList<ReadingArchiveEntry>();
    }
    public void LoadReadingArchive(ArrayList archive){
        this.archive=archive;
    }

    public void AddEntry(ReadingArchiveEntry entry){
        archive.add(entry);
    }
    //Question: This vs give List and do inplace operation?
    //TODO more sophisticated matching of searchstring, Regex?
    public ArrayList<ReadingArchiveEntry> searchByAuthor(String author){
       return (ArrayList<ReadingArchiveEntry>) archive.stream().filter(e->e.book().Author().contains(author)).toList();
    }
    //TODO more sophisticated matching of searchstring, Regex?
    public ArrayList<ReadingArchiveEntry> searchByTitle(String title){
        return (ArrayList<ReadingArchiveEntry>) archive.stream().filter(e->e.book().Author().contains(title)).toList();
    }

    //Use this from Output?
    //Don't have to String and make a method in Output?
    @Override
    public String toString() {
        String result="";
        String linebreak = System.getProperty("line.separator");
        for (var e:archive
             ) {
            result+=e.toString()+linebreak;
        }
        return result;
    }
}
