package DataModels.ObjectCredentials;
import java.io.Serializable;

public record Date(int day, int month, int year) implements Serializable {
    @Override
    public String toString() {
        return String.format("%02d-%02d-%04d", day, month, year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return year == date.year() && month == date.month() && day == date.day();
    }
}
