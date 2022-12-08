package use_cases;

import entities.CurrentUser;
import java.util.Date;
import java.util.HashMap;

import static use_cases.Predictor.PREDICTION_LENGTH;


/**
 * Use Case: A class to predict BMI over time
 */
public class BMIPredictor {

    /**
     * Returns a predicted BMI in the future over the days based on the inputted DataPointMap
     *         It simply uses the BMI formula taken from:
     *         <a href="https://www.cdc.gov/nccdphp/dnpao/growthcharts/training/bmiage/page5_1.htm">the CDC</a>
     *         Essentially, just dividing your weight in kg by your height in cm^2, then multiplying by 10 000
     *
     * @param data The data that is used for the prediction
     * @return A hashmap of Dates that map to a Double corresponding to the BMI prediction of that date
     */
    public static HashMap<Date, Double> predict(DataPointMap data) {
        HashMap<Date, Double> predictions = new HashMap<>();

        // Get date in milliseconds so can be easily manipulated
        long milliseconds = CurrentUser.currentDateEpoch();

        double height = CurrentUser.getInstance().getUser().getHeight();

        // if the DataPointMap is empty, simply return the BMI of the CurrentUser without changes
        if (data.getData().isEmpty()) {
            Date date = new Date(milliseconds + 86400000L); // make this prediciton for tomorrow
            Double bmi = CurrentUser.getInstance().getUser().getWeight() * 10000 / (height * height);
            predictions.put(date, bmi);
            return predictions;
        }

        // otherwise, make predictions for the PREDICTION_LENGTH number of days.
        for (int day = 1; day <= PREDICTION_LENGTH; day++) {
            // Get new date (there is 86400000 milliseconds per day)
            Date date = new Date(milliseconds + day * 86400000L);
            Double bmi = WeightPredictor.predict(data).get(date) / (height * height) * 10000;
            predictions.put(date, bmi);
        }

        return predictions;
    }


}
