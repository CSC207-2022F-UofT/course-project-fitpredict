package use_cases;

import java.util.Date;
import java.util.HashMap;

/**
 * A manager class that chooses which Use Case you will need - either predicting Weight, or BMI
 */
public class PredictManager {

    /**
     * Returns your predicted weight based on the inputted DataPointMap
     * @param data The data that is used for the weight prediction
     * @return A hashmap of Dates that map to a Double corresponding to the Weight prediction of that Date
     */
    public static HashMap<Date, Double> predictWeight(DataPointMap data) {
        return WeightPredictor.predict(data);
    }

    /**
     * Returns your predicted BMI based on the inputted DataPointMap
     * @param data The data that is used for the BMI prediction
     * @return A hashmap of Dates that map to a Double corresponding to the BMI prediction of that Date
     */
    public static HashMap<Date, Double> predictBMI(DataPointMap data) {
        return BMIPredictor.predict(data);
    }

    public static double predictCalories(DataPointMap data) { return CaloriePredictor.calculateCalories(data); }

}
