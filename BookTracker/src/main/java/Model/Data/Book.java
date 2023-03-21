package Model.Data;

import java.util.EnumSet;
import java.util.Set;

public record Book(
        String Title,
        String Author,
        int Pagecount,
        EnumSet<Genre> Genre

) {
    public Book(String Title, String Author, int Pagecount, EnumSet<Genre> Genre) {
        this.Title = Title;
        this.Author = Author;
        this.Pagecount = Pagecount;
        this.Genre = Genre;
    }

    public Book(String title, String author, EnumSet<Model.Data.Genre> genre) {
        this(title, author, -1, genre);
    }

    @Override
    public String toString() {
        return Title + "|" + Author + "|" + Genre;
    }
}
