package Predictor;

import java.util.Date;
import java.util.HashMap;

public abstract class Predictor {

    // TODO: convert all "predict" methods to STATIC! we do not need to create a whole new class for this
    abstract HashMap<Date, Double> predict(DataPointMap data);
}
