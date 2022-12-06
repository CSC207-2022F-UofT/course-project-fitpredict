package controllers;

import entities.CurrentUser;
import entities.Exercise;
import use_cases.DataInputBoundary;
import use_cases.ExerciseMap;

import java.util.ArrayList;
import java.util.Arrays;

public class DataInputController {

    final DataInputBoundary dataInputBoundary;
    /**
     * A controller for use case DataInputter to use
     */
    public DataInputController(DataInputBoundary boundary) {this.dataInputBoundary = boundary;}
    /**
     * Takes the user input and inputs the data of this day (month, day, year)
     * Returns false and data is not inputted if exercisesNames contains an invalid exercise
     * @param month The month of the calendar date
     * @param day The day of the calendar date
     * @param year The year of the calendar date
     * @param weight The weight inputted on this day
     * @param exercisesNames The names of the exercises done on this day
     * @param times The times spend on the exercises respectively to the position in exercisesNames
     */
    public boolean inputData(int month, int day, int year, double weight, String[] exercisesNames, String[] times) {
        ArrayList<Exercise> exercises = new ArrayList<>();
        double caloriesBurnt = 0;
        int length = exercisesNames.length;
        if (length == times.length) {
            if (length != 0) {
                for (int i = 0; i < exercisesNames.length; i++) {
                    for (Exercise exercise : ExerciseMap.get(CurrentUser.getInstance().getUser().getUsername())) {
                        if (exercise.getName().equals(exercisesNames[i])) {
                            exercises.add(exercise);
                            caloriesBurnt += exercise.getCaloriesBurntPerMin() * Integer.parseInt(times[i]);
                        }
                    }
                }
            }
            if (length == 0 || length == exercises.size()) {
                this.dataInputBoundary.inputData(month, day, year, weight, exercises, caloriesBurnt);
                return true;
            } else {return false;}
        }
        return false;}
}
