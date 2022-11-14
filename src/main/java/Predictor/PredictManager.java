package Predictor;

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

}
