package predictor;

import entities.CurrentUser;
import entities.DataPoint;
import org.junit.jupiter.api.Test;
import use_cases.BMIPredictor;
import use_cases.DataPointManager;
import use_cases.DataPointMap;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BMIPredictorTest {
    @Test
    public void BMIPredictorEmpty() {
        DataPointMap data = new DataPointMap();
        // Assert that the function works with an empty DataPointMap()
        CurrentUser user = new CurrentUser("mooga", "123",
                "123", 100.0, 100.0, "Male", "");
        // Assert that the function works with an empty DataPointMap(), BMI should be exactly the same as CurrentUser
        assertEquals(BMIPredictor.predict(data).size(), 100.0);
    }

    @Test
    public void BMIPredictorAllZeroes() {
        // test that the BMI predictor knows when not to change
        double[] caloriesBurnt = {
                0.0,
                0.0,
                0.00,
        };
        // create a current user with weight 100kg, height 100cm
        CurrentUser user = new CurrentUser("mooga", "123",
                "123", 100.0, 100.0, "Male", "");
        DataPointMap data = new DataPointMap();
        DataPointManager manager = new DataPointManager();
        for (int i = 0; i < 3; i++) {
            DataPoint input = manager.createDataPoint(1, 1, i);
            input.setCaloriesBurnt(caloriesBurnt[i]);
            data.addDataPoint(input);
        }
        HashMap<Date, Double> expected = new HashMap<>();
        // expected value is: (100 / (100^2)) * 10000 = 100
        expected.put(new Date(DataPoint.convertEpochMilliseconds(1, 1, 4)), 100.0);
        assertEquals(BMIPredictor.predict(data), expected);
    }

    @Test
    public void BMIPredictorNoChange() {
        // test that the BMI predictor knows when not to change
        double[] caloriesBurnt = {
                0.0,
                0.0,
                0.5,
                -0.5
        };
        // create a current user with weight 100kg, height 100cm
        CurrentUser user = new CurrentUser("mooga", "123",
                "123", 100.0, 100.0, "Male", "");
        DataPointMap data = new DataPointMap();
        DataPointManager manager = new DataPointManager();
        for (int i = 0; i < 4; i++) {
            DataPoint input = manager.createDataPoint(1, 1, i);
            input.setCaloriesBurnt(caloriesBurnt[i]);
            data.addDataPoint(input);
        }
        HashMap<Date, Double> expected = new HashMap<>();
        // expected value is: (100 / (100^2)) * 10000 = 100
        expected.put(new Date(DataPoint.convertEpochMilliseconds(1, 1, 4)), 100.0);
        assertEquals(BMIPredictor.predict(data), expected);

    }

    @Test
    public void BMIPredictorOneData() {
        double caloriesBurnt = 7700.0; // this is how many calories it takes to burn 1kg of fat
        DataPointMap data = new DataPointMap();
        // create a current user with weight 100kg, height 100cm
        CurrentUser user = new CurrentUser("mooga", "123",
                "123", 100.0, 100.0, "Male", "");

        DataPointManager manager = new DataPointManager();
        DataPoint input = manager.createDataPoint(1, 1, 1);
        input.setCaloriesBurnt(caloriesBurnt);
        data.addDataPoint(input);
        HashMap<Date, Double> expected = new HashMap<>();
        // expected value is: (99 / (100^2)) * 10000 = 99
        expected.put(new Date(DataPoint.convertEpochMilliseconds(1, 1, 2)), 99.0);
        assertEquals(BMIPredictor.predict(data), expected);
    }

    @Test
    public void BMIPredictorMultData() {
        double[] caloriesBurnt = {
                7700.0,
                30800.0,

        }; // this is how many calories it takes to burn 1kg of fat
        DataPointMap data = new DataPointMap();
        // create a current user with weight 100kg, height 100cm
        CurrentUser user = new CurrentUser("mooga", "123",
                "123", 100.0, 100.0, "Male", "");

        DataPointManager manager = new DataPointManager();
        for (int i = 0; i < 2; i++) {
            DataPoint input = manager.createDataPoint(1, 1, i);
            input.setCaloriesBurnt(caloriesBurnt[i]);
            data.addDataPoint(input);
        }
        HashMap<Date, Double> expected = new HashMap<>();
        // expected value is: (97.5 / (100^2)) * 10000 = 97.5
        expected.put(new Date(DataPoint.convertEpochMilliseconds(1, 1, 2)), 97.5);
        assertEquals(BMIPredictor.predict(data), expected);
    }
}
