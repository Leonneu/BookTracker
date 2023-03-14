package Model.Data;

public record Date(int day,int Month,int Year) {
    public Date(int day, int Month, int Year) { //TODO Validate Date?
        this.day = day;
        this.Month = Month;
        this.Year = Year;
    }

    public Date(int month, int year) {
        this(0, month, year);
    }

    public Date(int year) {
        this(0, 0, year);
    }
}
