package predictor;

import entities.CurrentUser;
import entities.DataPoint;
import entities.User;
import org.junit.jupiter.api.Test;
import use_cases.BMIPredictor;
import use_cases.DataPointManager;
import use_cases.DataPointMap;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BMIPredictorTest {
    DataPointManager manager = new DataPointManager();
    // create a current user with weight 100kg, height 100cm
    User user = new CurrentUser("mooga", "123",
            "123", 100.0, 101.0, "Male", "");

    @Test
    public void BMIPredictorEmpty() {
        DataPointMap data = new DataPointMap();
        CurrentUser.getInstance().setUser(user);
        // Assert that the function works with an empty DataPointMap(), BMI should be exactly the same as CurrentUser
        Date new_date = new Date(DataPoint.convertEpochMilliseconds(1, 1, 1));
        assertEquals(BMIPredictor.predict(data).get(new_date), 100.0, 0.1);
    }

    @Test
    public void BMIPredictorAllZeroes() {
        // test that the BMI predictor knows when not to change
        double[] caloriesBurnt = {
                0.0,
                0.0,
                0.00,
        };
        DataPointMap data = new DataPointMap();
        for (int i = 0; i < 3; i++) {
            DataPoint input = manager.createDataPoint(1, 1, i);
            input.setCaloriesBurnt(caloriesBurnt[i]);
            input.setWeight(100.0);
            data.addDataPoint(input);
        }
        HashMap<Date, Double> expected = new HashMap<>();
        CurrentUser.getInstance().setUser(user);
        // expected value is: (100 / (101^2)) * 10000 ~ 98.03
        Date new_date = new Date(DataPoint.convertEpochMilliseconds(1, 1, 4));
        assertEquals(BMIPredictor.predict(data).get(new_date), 98.03, 0.1);
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
        DataPointMap data = new DataPointMap();
        for (int i = 0; i < 4; i++) {
            DataPoint input = manager.createDataPoint(1, 1, i);
            input.setCaloriesBurnt(caloriesBurnt[i]);
            data.addDataPoint(input);
        }
        HashMap<Date, Double> expected = new HashMap<>();
        CurrentUser.getInstance().setUser(user);
        // expected value is: (100 / (101^2)) * 10000 ~ 98.03
        Date new_date = new Date(DataPoint.convertEpochMilliseconds(1, 1, 4));
        assertEquals(BMIPredictor.predict(data).get(new_date), 98.03, 0.1);

    }

    @Test
    public void BMIPredictorOneData() {
        double caloriesBurnt = 7700.0; // this is how many calories it takes to burn 1kg of fat
        DataPointMap data = new DataPointMap();
        // create a current user with weight 100kg, height 100cm
        DataPoint input = manager.createDataPoint(1, 1, 1);
        input.setCaloriesBurnt(caloriesBurnt);
        data.addDataPoint(input);
        HashMap<Date, Double> expected = new HashMap<>();
        CurrentUser.getInstance().setUser(user);
        // expected value is: (99 / (101^2)) * 10000 ~ 97.05
        Date new_date = new Date(DataPoint.convertEpochMilliseconds(1, 1, 2));
        assertEquals(BMIPredictor.predict(data).get(new_date), 97.05, 0.1);
    }

    @Test
    public void BMIPredictorMultData() {
        double[] caloriesBurnt = {
                7700.0,
                30800.0,

        }; // this is how many calories it takes to burn 1kg of fat
        DataPointMap data = new DataPointMap();
        for (int i = 0; i < 2; i++) {
            DataPoint input = manager.createDataPoint(1, 1, i);
            input.setCaloriesBurnt(caloriesBurnt[i]);
            data.addDataPoint(input);
        }
        HashMap<Date, Double> expected = new HashMap<>();
        CurrentUser.getInstance().setUser(user);
        // expected value is: (97.5 / (101^2)) * 10000 ~ 95.1
        Date newDate = new Date(DataPoint.convertEpochMilliseconds(1, 1, 2));
        assertEquals(BMIPredictor.predict(data).get(newDate), 95.14, 0.1);
    }
}
