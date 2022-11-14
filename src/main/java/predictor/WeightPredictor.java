package predictor;

import java.util.Date;
import java.util.HashMap;

/*
    Use Case: A class to predict weight over time
 */
public class WeightPredictor extends Predictor {

    /*
        Returns an estimate of what weight you will be at future dates, based on previous inputted
         data in the DataMap.

        Functionality: It takes your average calories burnt throughout the map (i.e all days),
         and then uses this to estimate how much you will burn.
         Since each pound of fat is 3500 calories, if you burn, for instance, an average of
         500 calories per day (i.e, you are in a 500 calorie deficit every day), it will calculate
         that you will lose 1/7 ~ 0.143 pounds of fat per day.

        This function uses information from:
        https://www.omnicalculator.com/health/calorie-deficit
        to predict weight based on calories burnt from workout.
        */
    public static HashMap<Date, Double> predict(DataPointMap data) {

        HashMap<Date, Double> predictions = new HashMap<>();
        double caloriesBurnt = CaloriePredictor.calculateCalories(data);

        // TODO: create a prediction based on caloriesBurnt as to how much weight you will
        //  lose if you continue this deficit

        return predictions; // placeholder
    }
}
