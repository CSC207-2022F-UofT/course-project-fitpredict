package predictor;

import static org.junit.jupiter.api.Assertions.*;

import entities.DataPoint;
import org.junit.jupiter.api.Test;
import use_cases.CaloriePredictor;
import use_cases.DataPointManager;
import use_cases.DataPointMap;

import java.util.Arrays;

public class CaloriePredictorTest {
    @Test
    public void testCaloriePredictorEmpty() {
        DataPointMap data = new DataPointMap();
        assertEquals(CaloriePredictor.calculateCalories(data), 0.0, 0.01);
    }

    @Test
    public void testCaloriePredictorZero() {
        double caloriesBurnt = 0.0;
        DataPointMap data = new DataPointMap();
        DataPointManager manager = new DataPointManager();
        DataPoint input1 = manager.createDataPoint(1, 1, 1);
        input1.setCaloriesBurnt(caloriesBurnt);
        data.addDataPoint(input1);
        assertEquals(CaloriePredictor.calculateCalories(data), caloriesBurnt, 0.01);
    }

    @Test
    public void testCaloriePredictorOneInput() {
        double caloriesBurnt = 100.5;
        DataPointMap data = new DataPointMap();
        DataPointManager manager = new DataPointManager();
        DataPoint input1 = manager.createDataPoint(1, 1, 1);
        input1.setCaloriesBurnt(caloriesBurnt);
        data.addDataPoint(input1);
        assertEquals(CaloriePredictor.calculateCalories(data), caloriesBurnt, 0.01);
    }

    @Test
    public void testCaloriePredictorManyInputs() {
        double[] caloriesBurnt = {
                100.5,
                120.5,
                92.4,
                11.3
        };
        DataPointMap data = new DataPointMap();
        DataPointManager manager = new DataPointManager();
        for (int i = 1; i < 5; i++) {
            DataPoint input = manager.createDataPoint(1, i, 1);
            input.setCaloriesBurnt(caloriesBurnt[i - 1]);
            data.addDataPoint(input);
        }
        assertEquals(CaloriePredictor.calculateCalories(data),
                Arrays.stream(caloriesBurnt).sum() / caloriesBurnt.length, 0.01);
    }

}
