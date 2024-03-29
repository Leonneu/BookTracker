package Plugin.Application.Model;

import java.util.EnumSet;
import java.util.Objects;

public record Book(
        String title,
        String author,
        int pagecount,
        Language language,
        EnumSet<Genre> Genre

) {

    public Book(String title, String author, int pagecount, Language language) {
        this(title, author, pagecount, language, null);
    }

    public Book(String title, String author, int pagecount, EnumSet<Plugin.Application.Model.Genre> genre) {
        this(title, author, pagecount, Language.EN, genre);
    }

    public Book(String title, String author, EnumSet<Plugin.Application.Model.Genre> genre) {
        this(title, author, -1, Language.EN, genre);
    }

    public Book(Book oldBook, EnumSet<Genre> genre) {
        this(oldBook.title, oldBook.author, oldBook.pagecount, oldBook.language, genre);
    }

    @Override
    public String toString() {
        StringBuilder genreString = new StringBuilder();
        if (Genre != null) {
            for (Genre g : Genre
            ) {
                if (genreString.length() > 0) genreString.append(",");
                genreString.append(g.toString());
            }
        }
        return "%-20s|%-20s|%10d|%7s|%-60s".formatted(title, author, pagecount, language, genreString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return title.equals(book.title) && author.equals(book.author) && language == book.language;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, language);
    }
}
