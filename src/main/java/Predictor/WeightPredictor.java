package Predictor;

import java.util.HashMap;

public class WeightPredictor extends Predictor {

    public HashMap<Integer, Double> predict(DataPointMap data) {
        /*
        This function uses information from:
        https://www.omnicalculator.com/health/calorie-deficit
        to predict weight based on calories burnt from workout.

        It takes your average calories burnt throughout the map (i.e all days), and then
         uses this to estimate how much you will burn.
         since each pound of fat is 3500 calories, if you burn, for instance, an average of
         500 calories per day (i.e, you are in a 500 calorie deficit every day), it will calculate
         that you will lose 1/7 ~ 0.143 pounds of fat per day.
         */

        HashMap<Integer, Double> predictions = new HashMap<>();
        CaloriePredictor caloriePredictor = new CaloriePredictor();
        double caloriesBurnt = caloriePredictor.calculateCalories(data);

        // TODO: create a prediction based on caloriesBurnt as to how much weight you will
        //  lose if you continue this deficit

        return predictions; // placeholder
    }
}
