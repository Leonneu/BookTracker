package Plugin.Application.Model;

import java.time.LocalDate;

public final class BookDateWrapper{
   private final LocalDate date;

    public BookDateWrapper(int day, int month, int year) { //TODO Validate Date?
        this.date = LocalDate.of(year,month,day);
    }

    public BookDateWrapper(){
        this.date = LocalDate.now();
    }

    @Override
    public String toString() {
        return date.getDayOfMonth()+ "." + date.getMonthValue() + "." + date.getYear();
    }

    public int day() {
        return date.getDayOfMonth();
    }

    public int month() {
        return date.getMonthValue();
    }

    public int year() {
        return date.getYear();
    }

    public int getDifference(BookDateWrapper otherDate){
        return date.until(LocalDate.of(otherDate.year(),otherDate.month(),otherDate.day())).getDays()+1;
    }

}
