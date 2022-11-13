package Predictor;

import java.util.HashMap;

public abstract class Predictor {

    abstract HashMap<Integer, Double> predict(DataPointMap data);
}
