package DisplayZoom;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

public class DataPoint {
    private Date date;
    private ArrayList<Exercise> exerciseList;
    private float weight;
    private float caloriesBurnt;
    public DataPoint(int month, int day, int year, ArrayList<Exercise> exercises, float calories) {
        date = new Date(convertEpochMilliseconds(month, day, year));
        exerciseList = exercises;
        caloriesBurnt = calories;
    }

    public DataPoint() {
    }

    public long convertEpochMilliseconds(int month, int day, int year) {
        LocalDateTime time = LocalDateTime.of(year, month, day, 0, 0);
        return time.toEpochSecond(ZoneOffset.UTC);
    }

    public Date getDate() {
        return this.date;
    }

    public ArrayList<Exercise> getExerciseList() {
        return this.exerciseList;
    }

    public float getCaloriesBurnt() {
        return this.caloriesBurnt;
    }

    public void setCaloriesBurnt(float calories) {
        this.caloriesBurnt = calories;
    }

    public float getWeight() {
        return this.weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
