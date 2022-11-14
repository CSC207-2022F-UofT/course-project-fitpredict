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
        date = new Date(convertEpochMilliseconds(month, day, year));
    }

    public long convertEpochMilliseconds(int month, int day, int year) {
        LocalDateTime time = LocalDateTime.of(year, month, day, 0, 0);
        long epochMilliseconds = time.toEpochSecond(ZoneOffset.UTC);
        return epochMilliseconds;
    }
}
