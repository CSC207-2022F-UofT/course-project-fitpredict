package predictor;

import java.util.Date;
import java.util.HashMap;

/*
       A manager class that chooses which Use Case you will need - either predicting Weight, or BMI
 */
public class PredictManager {

    // HashMap is a map from day to the weight prediction of that day
    /*
        Returns your predicted weight based on the inputted DataPointMap
     */
    public static HashMap<Date, Double> predictWeight(DataPointMap data) {
        return WeightPredictor.predict(data);
    }

    // Returns a HashMap from the day to the predicted BMI on that day
    public static HashMap<Date, Double> predictBMI(DataPointMap data) {
        return BMIPredictor.predict(data);
    }

}
