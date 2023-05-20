package ObjectCredentials;
import java.io.Serializable;
import java.util.Objects;

public class Date implements Serializable {
    private int year;
    private int month;
    private int day;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return String.format("%02d-%02d-%04d", day, month, year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return year == date.getYear() && month == date.getMonth() && day == date.getDay();
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}
