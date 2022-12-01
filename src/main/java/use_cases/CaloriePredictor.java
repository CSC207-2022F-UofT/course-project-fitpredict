package use_cases;

import entities.DataPoint;

import java.util.Date;
import java.util.Map;

/**
 * Use Case - A class to predict calories burnt over time
 */
public class CaloriePredictor {

    /**
     * Returns an average of the calories burnt over the entire DataPointMap
     * @param data The data that is used for the calorie prediction
     * @return A double that corresponds to the average calories burnt throughout the entire DataPointMap
     */
    public static double calculateCalories(DataPointMap data) {
        double prediction = 0.0f;

        Map<Date, DataPoint> dataMap = data.getData();

        for (Map.Entry<Date, DataPoint> entry: dataMap.entrySet()) {
            prediction += entry.getValue().getCaloriesBurnt();
        }

        if (dataMap.size() == 0) {
            return prediction;  // to account for divide by zero errors
        }
        return prediction / dataMap.size(); // return average calories burnt
    }

}
