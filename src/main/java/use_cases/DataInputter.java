package use_cases;

import entities.CurrentUser;
import entities.DataPoint;
import entities.Exercise;

import java.util.ArrayList;

public class DataInputter implements DataInputBoundary {
    public void inputData(int month, int day, int year, double weight, ArrayList<Exercise> exercises, double caloriesBurnt) {
        DataPointMap dataPointMap = CurrentUser.getInstance().getDataPointMap();
        DataPoint dataPoint = new DataPoint(month, day, year);
        dataPoint.setWeight(weight);
        dataPoint.addExercise(exercises);
        dataPoint.setCaloriesBurnt(caloriesBurnt);
        dataPointMap.addDataPoint(dataPoint);
    }
}
