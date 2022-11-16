package predictor;

import java.util.Date;
import java.util.HashMap;

/*
    Abstract Use Case: All predictions extend this, and implement "predict"
*/
public class Predictor {

    static HashMap<Date, Double> predict(DataPointMap data) {
        return null;
    }

}
