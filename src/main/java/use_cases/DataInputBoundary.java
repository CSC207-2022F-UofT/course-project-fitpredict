package use_cases;

import entities.Exercise;
import java.util.ArrayList;

public interface DataInputBoundary {
    public void inputData(int month, int day, int year, double weight, ArrayList<Exercise> exercises, double caloriesBurnt);
}
