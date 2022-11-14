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

    /*
    Helper function that is used by a constructor
    Converts an input of (month, day, year) to milliseconds since Epoch
    This is only necessary because other Date constructors are deprecated
     */
    public long convertEpochMilliseconds(int month, int day, int year) {
        LocalDateTime time = LocalDateTime.of(year, month, day, 0, 0);
        return time.toEpochSecond(ZoneOffset.UTC);
    }

    /*
    Getter function that returns the date of the DataPoint
     */
    public Date getDate() {
        return this.date;
    }

    /*
    Getter function that returns the exercises stored in the DataPoint
     */
    public ArrayList<Exercise> getExerciseList() {
        return this.exerciseList;
    }

    /*
    Getter function that returns the number of calories burnt that is stored in the DataPoint
    */
    public float getCaloriesBurnt() {
        return this.caloriesBurnt;
    }

    /*
    Setter function that sets the number of calories burnt in the DataPoint
     */
    public void setCaloriesBurnt(float calories) {
        this.caloriesBurnt = calories;
    }

    /*
    Getter function that returns the user's weight stored in the DataPoint
     */
    public float getWeight() {
        return this.weight;
    }

    /*
    Setter function that sets the weight of the user stored in the DataPoint
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }
}
