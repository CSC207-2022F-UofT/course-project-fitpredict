package Predictor;

import java.util.Date;
import java.util.HashMap;

public abstract class Predictor {

    abstract HashMap<Date, Double> predict(DataPointMap data);
}
