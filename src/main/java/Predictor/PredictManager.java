package Predictor;

import java.util.Date;
import java.util.HashMap;

public class PredictManager {

    // HashMap is a map from day to the weight prediction of that day!
    public HashMap<Date, Double> predictWeight(DataPointMap data) {
        WeightPredictor weightPredictor = new WeightPredictor();
        HashMap<Date, Double> predictions = weightPredictor.predict(data);
        return predictions;
    }

}
