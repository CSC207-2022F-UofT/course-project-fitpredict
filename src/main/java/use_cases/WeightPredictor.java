package use_cases;

import entities.CurrentUser;

import java.util.Date;
import java.util.HashMap;


/**
 * Use Case: A class to predict weight over time
 */
public class WeightPredictor extends Predictor {
    /**
     * Returns an estimate of what weight you will be at future dates, based on previous inputted
     * data in the DataMap.
     * Functionality: It takes your average calories burnt throughout the map (i.e. all days),
     * and then uses this to estimate how much you will burn.
     * Since each pound of fat is 3500 calories, if you burn, for instance, an average of
     * 500 calories per day (i.e, you are in a 500 calorie deficit every day), it will calculate
     * that you will lose 1/7 ~ 0.143 pounds of fat per day.
     * This function uses information from:
     * <a href="https://www.omnicalculator.com/health/calorie-deficit">OmniCalculator</a>
     * to predict weight based on calories burnt from workout.
     *
     * @param data The data that is used for the weight prediction
     * @return A hashmap of Dates that map to a Double corresponding to the Weight prediction of that Date
     */
    public static HashMap<Date, Double> predict(DataPointMap data) {
        // if there is an empty DataPointMap inputted, return an empty result
        if (data.getData().isEmpty()) {
            return new HashMap<>();
        }

        HashMap<Date, Double> predictions = new HashMap<>();
        double caloriesBurnt = CaloriePredictor.calculateCalories(data);

        // Get date in milliseconds so can be easily manipulated
        long milliseconds = CurrentUser.currentDateEpoch();

        double finalWeight = CurrentUser.getInstance().getUser().getWeight();

        // Create predictions map
        for (int day = 1; day <= PREDICTION_LENGTH; day++) {
            // Get new date (there is 86400000 milliseconds per day)
            Date date = new Date(milliseconds + day * 86400000L);

            predictions.put(date, finalWeight - day * caloriesBurnt / 3500);
        }

        return predictions;
    }
}