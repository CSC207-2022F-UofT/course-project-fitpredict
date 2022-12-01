package predictor;

import entities.CurrentUser;
import entities.DataPoint;
import entities.User;
import org.junit.jupiter.api.Test;
import use_cases.BMIPredictor;
import use_cases.DataPointManager;
import use_cases.DataPointMap;

import java.util.Date;

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

        // Getting date to check if weight is unchanged at the end
        long milliseconds = CurrentUser.currentDateEpoch();
        // get current date, then add one to date (tomorrow's prediction)
        Date finalDate = new Date(milliseconds + 86400000L);

        assertEquals(BMIPredictor.predict(data).get(finalDate), 98.03, 0.1);
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
        for (int i = 1; i < 4; i++) {
            DataPoint input = manager.createDataPoint(1, i, 1);
            input.setCaloriesBurnt(caloriesBurnt[i - 1]);
            input.setWeight(100.0);
            data.addDataPoint(input);
        }
        CurrentUser.getInstance().setUser(user);

        // Getting date to check if weight is unchanged at the end
        long milliseconds = CurrentUser.currentDateEpoch();
        // get current date, then add one to date (tomorrow's prediction)
        Date finalDate = new Date(milliseconds + 86400000L);

        // expected value is: (100 / (101^2)) * 10000 ~ 98.03
        assertEquals(98.03, BMIPredictor.predict(data).get(finalDate), 0.1);
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
        for (int i = 1; i < 5; i++) {
            DataPoint input = manager.createDataPoint(1, i, 4);
            input.setCaloriesBurnt(caloriesBurnt[i - 1]);
            data.addDataPoint(input);
        }
        CurrentUser.getInstance().setUser(user);
        // expected value is: (100 / (101^2)) * 10000 ~ 98.03
        // Getting date to check if weight is unchanged at the end
        long milliseconds = CurrentUser.currentDateEpoch();
        // get current date, then add one to date (tomorrow's prediction)
        Date finalDate = new Date(milliseconds + 86400000L);

        assertEquals(BMIPredictor.predict(data).get(finalDate), 98.03, 0.1);

    }

    @Test
    public void BMIPredictorOneData() {
        double caloriesBurnt = 3500.0; // this is how many calories it takes to burn 1lb of fat
        DataPointMap data = new DataPointMap();
        // create a current user with weight 100kg, height 100cm
        DataPoint input = manager.createDataPoint(1, 1, 1);
        input.setCaloriesBurnt(caloriesBurnt);
        data.addDataPoint(input);
        CurrentUser.getInstance().setUser(user);
        // expected value is: (99 / (101^2)) * 10000 ~ 97.05

        // Getting date to check if weight is unchanged at the end
        long milliseconds = CurrentUser.currentDateEpoch();
        // get current date, then add one to date (tomorrow's prediction)
        Date finalDate = new Date(milliseconds + 86400000L);

        assertEquals(BMIPredictor.predict(data).get(finalDate), 97.05, 0.1);
    }

    @Test
    public void BMIPredictorMultData() {
        double[] caloriesBurnt = {
                3500.0,
                14000.0,

        }; // this is how many calories it takes to burn 1kg of fat
        DataPointMap data = new DataPointMap();
        for (int i = 1; i < 3; i++) {
            DataPoint input = manager.createDataPoint(1, i, 1);
            input.setCaloriesBurnt(caloriesBurnt[i - 1]);
            data.addDataPoint(input);
        }
        CurrentUser.getInstance().setUser(user);
        // expected value is: (97.5 / (101^2)) * 10000 ~ 95.5

        // Getting date to check if weight is unchanged at the end
        long milliseconds = CurrentUser.currentDateEpoch();
        // get current date, then add one to date (tomorrow's prediction)
        Date finalDate = new Date(milliseconds + 86400000L);

        assertEquals(BMIPredictor.predict(data).get(finalDate), 95.58, 0.1);
    }
}
