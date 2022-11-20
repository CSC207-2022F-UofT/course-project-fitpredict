package predictor;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CaloriePredictorTest {
    @Test
    public void CaloriePredictorZero() {
        DataPointMap data = new DataPointMap();
        assertEquals(CaloriePredictor.calculateCalories(data), 0.0);
    }

    @Test
    public void CaloriePredictorOneInput() {
        double caloriesBurnt = 100.5;
        DataPointMap data = new DataPointMap();
        DataPointManager manager = new DataPointManager();
        DataPoint input1 = manager.createDataPoint(1, 1, 1);
        input1.setCaloriesBurnt(caloriesBurnt);
        data.addDataPoint(input1);
        assertEquals(CaloriePredictor.calculateCalories(data), caloriesBurnt);
    }

    @Test
    public void CaloriePredictorManyInputs() {
        double[] caloriesBurnt = {
                100.5,
                120.5,
                92.4,
                11.3
        };
        DataPointMap data = new DataPointMap();
        DataPointManager manager = new DataPointManager();
        for (int i = 0; i < 4; i++) {
            DataPoint input = manager.createDataPoint(1, 1, i);
            input.setCaloriesBurnt(caloriesBurnt[i]);
            data.addDataPoint(input);
        }
        assertEquals(CaloriePredictor.calculateCalories(data),
                Arrays.stream(caloriesBurnt).sum() / caloriesBurnt.length);
    }

}
