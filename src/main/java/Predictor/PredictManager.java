package Predictor;

import java.util.HashMap;

public class PredictManager {

    // HashMap is a map from day to the weight prediction of that day!
    public HashMap<Integer, Double> predictWeight(DataPointMap data) {
        WeightPredictor weightPredictor = new WeightPredictor();
        HashMap<Integer, Double> predictions = weightPredictor.predict(data);
        return predictions;
    }

}
