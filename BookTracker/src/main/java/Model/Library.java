package Model;

import java.io.*;
import java.util.ArrayList;

public class Library {

    ArrayList<Book> Books = new ArrayList<>();

    public Library(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                var data = line.split("\\|");
                Books.add(new Book(data[0],data[1],Genre.valueOf(data[2])));
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBook(Book book){
        Books.add(book);
    }
    public ArrayList<Book> getBooks(){
        return Books;
    }
    public void saveLibrary(String path){
        File file = new File(path);
        try (PrintWriter out = new PrintWriter(file)) {
            for (Book b:Books
                 ) {
                out.println(b.toString());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
