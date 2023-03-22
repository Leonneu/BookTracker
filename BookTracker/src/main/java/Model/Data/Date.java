package Model.Data;

public record Date(int day, int month, int year) {
    public Date(int day, int month, int year) { //TODO Validate Date?
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(int month, int year) {
        this(0, month, year);
    }

    public Date(int year) {
        this(0, 0, year);
    }

    @Override
    public String toString() {
        return day +"."+ month +"."+ year;
    }
}
