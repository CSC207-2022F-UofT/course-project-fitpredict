package entities;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

/**
 * DataPoint Entity
 */
public class DataPoint {
    private final Date date;
    private ArrayList<Exercise> exerciseList;
    private double weight;
    private double caloriesBurnt;

    /**
     * A DataPoint containing fitness stats information for 1 calendar day
     * @param month The month of the calendar date - between 1-12, inclusive
     * @param day The day of the calendar date - between 1-31, inclusive (depending on month)
     * @param year The year of calendar date - greater than or equal to 1
     *
     */
    public DataPoint(int month, int day, int year) {
        date = new Date(convertEpochMilliseconds(month, day, year));
        exerciseList = new ArrayList<Exercise>();
    }

    /**
     * A DataPoint containing fitness stats information for 1 calendar day
     * @param date The date of the calendar date
     *
     */
    public DataPoint(Date date) {
        this.date = date;
        exerciseList = new ArrayList<Exercise>();
    }

    /**
     * Helper function that is used by a constructor - Converts month, day, year to milliseconds since Epoch
     * This is only necessary because other Date constructors are deprecated
     * @param month The month of the calendar date - between 1-12, inclusive
     * @param day The day of the calendar date - between 1-31, inclusive (depending on month)
     * @param year The year of calendar date - greater than or equal to 1
     * @return epochSeconds number of seconds from Epoch
     */
    public static long convertEpochMilliseconds(int month, int day, int year) {
        LocalDateTime time = LocalDateTime.of(year, month, day, 5, 0);
        return time.toEpochSecond(ZoneOffset.UTC) * 1000;
    }

    /**
     * Gets the date of the DataPoint
     * @return date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Gets the exercises stored in the DataPoint
     * @return exerciseList
     */
    public ArrayList<Exercise> getExerciseList() {
        return this.exerciseList;
    }

    /**
     * Sets exerciseList by adding an Exercise.
     * @param exercise Exercise object
     */
    public void addExercise(Exercise exercise) {
        this.exerciseList.add(exercise);
    }

    /**
     * Sets exerciseList by merging it with another ArrayList of Exercise objects
     * @param exercises ArrayList of Exercise objects to be added
     */
    public void addExercise(ArrayList<Exercise> exercises) {
        this.exerciseList.addAll(exercises);
    }

    /**
     * Gets number of caloriesBurnt
     * @return caloriesBurnt
     */
    public double getCaloriesBurnt() {
        return this.caloriesBurnt;
    }

    /**
     * Sets number of caloriesBurnt
     * @param calories number of calories
     */
    public void setCaloriesBurnt(double calories) {
        this.caloriesBurnt = calories;
    }

    /**
     * Gets weight
     * @return weight
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * Sets weight
     * @param weight weight stored in DataPoint
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }
}
