package Predictor;

import org.junit.experimental.theories.DataPoint;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CaloriePredictor {

    public float calculateCalories(DataPointMap data) {
        float prediction = 0.0f;

        Map<Date, DataPoint> dataMap = data.getData();

        for (Map.Entry<Date, DataPoint> entry: dataMap.entrySet()) {
            prediction += entry.getValue().getCaloriesBurnt();
        }

        return prediction / dataMap.size(); // return average calories burnt
    }

}
