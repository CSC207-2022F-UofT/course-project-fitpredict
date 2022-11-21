package use_cases;

import java.util.Date;
import java.util.HashMap;

/**
 * Abstract Use Case: All predictions extend this, and implement "predict"
 */
public abstract class Predictor {

    // This is the lengths of the predictions in days
    static final int PREDICTION_LENGTH = 90;
    /**
     * An abstract class that will return some prediction based on the inputted DataPointMap
     * @param data The data that is used for the prediction
     * @return A hashmap of Dates that map to a Double corresponding to some prediction of that Date
     */
    static HashMap<Date, Double> predict(DataPointMap data) {
        return null;
    }
}
