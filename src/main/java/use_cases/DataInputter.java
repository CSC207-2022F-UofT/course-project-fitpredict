package use_cases;

import entities.CurrentUser;
import entities.DataPoint;
import entities.Exercise;
import java.util.ArrayList;

/**
 * Inputs the data given by the user
 */
public class DataInputter implements DataInputBoundary {
    /**
     * Takes the user input and inputs the data of this day (month, day, year)
     * @param month The month of the calendar date
     * @param day The day of the calendar date
     * @param year The year of the calendar date
     * @param weight The weight inputted on this day
     * @param exercises The exercises done on this day
     * @param caloriesBurnt The number of calories burned from the exercises
     */
    public void inputData(int month, int day, int year, double weight, ArrayList<Exercise> exercises, double caloriesBurnt) {
        DataPointMap dataPointMap = CurrentUser.getInstance().getUser().getDataPointMap();
        DataPointManager manager = new DataPointManager();
        DataPoint dataPoint = manager.createDataPoint(month, day, year);
        dataPoint.setWeight(weight);
//        for (Exercise exercise : exercises) {dataPoint.addExercise(exercise);}
        dataPoint.addExercise(exercises);
        dataPoint.setCaloriesBurnt(caloriesBurnt);
        dataPointMap.addDataPoint(dataPoint);
    }
}
