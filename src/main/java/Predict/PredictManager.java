package Predict;

import java.util.Date;
import java.util.HashMap;

/*
       A manager class that chooses which Use Case you will need - either predicting Weight, or BMI
 */
public class PredictManager {

    /*
        Returns your predicted weight based on the inputted DataPointMap
    */

    public static HashMap<Date, Double> predictWeight(DataPointMap data) {
        return WeightPredictor.predict(data);
    }

}
