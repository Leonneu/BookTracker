package Model;

public record Book(
        String Title,
        String Author,
        Genre genre

) {
    @Override
    public String toString() {
        return Title + "|" + Author + "|" + genre;
    }
}
