package data;

public record Book(
        String Title,
        String Author,
        Genre genre

) {
    @Override
    public String toString() {
        return "Book{" +
                "Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                ", genre=" + genre +
                '}';
    }
}
