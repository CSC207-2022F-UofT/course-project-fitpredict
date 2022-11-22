package data_input;

import java.util.ArrayList;

public class DataInputController {
    final DataInputBoundary dataInputBoundary;

    /**
     * A controller for use case DataInputter to use
     */
    public DataInputController(DataInputBoundary dataInputBoundary) {this.dataInputBoundary = dataInputBoundary;}

    public DataPoint inputData(int month, int day, int year, ArrayList<Exercise> exercises,
                               double weight, int caloriesBurnt) {
        return DataInputBoundary.inputData(month, day, year, exercises, weight, caloriesBurnt);
    }
}
