package use_cases;

import java.util.Date;
import java.util.HashMap;

/**
 * Abstract Use Case: All predictions extend this, and implement "predict"
 */
public abstract class Predictor {

    /**
     * An abstract class that will return some prediction based on the inputted DataPointMap
     * @param data The data that is used for the prediction
     * @return A hashmap of Dates that map to a Double corresponding to some prediction of that Date
     */
    static HashMap<Date, Double> predict(DataPointMap data) {
        return null;
    }
}
