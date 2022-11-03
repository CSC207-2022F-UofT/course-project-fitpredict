package DisplayZoom;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

public class DataPoint {
    Date date;
    ArrayList exerciseList = new ArrayList();
    float weight;
    float caloriesBurnt;
    public DataPoint(int month, int day, int year, ArrayList<Exercise> exerciseList) {
        long epochMilliseconds = convertLongMilliseconds(month, day, year);
        date = new Date(epochMilliseconds);
    }

    public long convertLongMilliseconds(int month, int day, int year) {
        LocalDateTime time = LocalDateTime.of(2022, 10, 31, 0, 0);
        long epochMilliseconds = time.toEpochSecond(ZoneOffset.UTC);
        return epochMilliseconds;
    }
}
