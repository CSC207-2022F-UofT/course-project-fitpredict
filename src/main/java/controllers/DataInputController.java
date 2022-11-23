package controllers;

import entities.CurrentUser;
import entities.Exercise;
import use_cases.DataInputBoundary;
import use_cases.ExerciseMap;

import java.util.ArrayList;

public class DataInputController {

    final DataInputBoundary dataInputBoundary;
    /**
     * A controller for use case DataInputter to use
     */
    public DataInputController(DataInputBoundary boundary) {
        this.dataInputBoundary = boundary;

    }
    public void inputData(int month, int day, int year, double weight, String[] exercisesNames, String[] times) {
            double caloriesBurnt = 0;
            ArrayList<Exercise> exercises = new ArrayList<>();
            for (int i = 0; i <= exercisesNames.length; i++) {
                for (Exercise exercise : ExerciseMap.get(CurrentUser.getInstance().getUsername())) {
                    if (exercise.getName().equals(exercisesNames[i])) {
                        exercises.add(exercise);
                        caloriesBurnt += exercise.getCaloriesBurntPerMin() * Integer.parseInt(times[i]);
                }
            }
            this.dataInputBoundary.inputData(month, day, year, weight, exercises, caloriesBurnt);
        }
    }
}
