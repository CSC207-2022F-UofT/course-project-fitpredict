package predictor;

import entities.CurrentUser;
import entities.DataPoint;
import entities.User;
import org.junit.Test;
import use_cases.*;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PredictManagerTest {
    DataPointManager manager = new DataPointManager();
    // create a current user with weight 100kg, height 100cm
    User user = new CurrentUser("mooga", "123",
            "123", 100.0, 101.0, "Male", "");

    User u = new User("Josh", "123abc", "123abc",
            62.0, 150.0, "Male", "2006-10-12");

    @Test
    public void BMIPredictorEmpty() {
        DataPointMap data = new DataPointMap();
        CurrentUser.getInstance().setUser(user);
        // Assert that the function works with an empty DataPointMap(), BMI should be exactly the same as CurrentUser

        // Getting date to check if weight is unchanged at the end
        long milliseconds = CurrentUser.currentDateEpoch();
        // get current date, then add one to date (tomorrow's prediction)
        Date finalDate = new Date(milliseconds + 86400000L);

        assertEquals(PredictManager.predictBMI(data).get(finalDate), 98.03, 0.1);
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
        assertEquals(98.03, PredictManager.predictBMI(data).get(finalDate), 0.1);
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

        assertEquals(PredictManager.predictBMI(data).get(finalDate), 98.03, 0.1);

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

        assertEquals(PredictManager.predictBMI(data).get(finalDate), 97.05, 0.1);
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

        assertEquals(PredictManager.predictBMI(data).get(finalDate), 95.58, 0.1);
    }

    @Test
    public void WeightPredictorZero() {
        DataPointMap data = new DataPointMap();
        // Assert that the return type is empty
        assertEquals(0, PredictManager.predictWeight(data).size());
    }

    @Test
    public void WeightPredictorCalorieDeficitZero() {
        DataPointMap data = new DataPointMap();
        CurrentUser.getInstance().setUser(u);
        for (int day = 1; day <= 10; day ++) {
            DataPoint dataPoint = new DataPoint(1, day, 2000);
            dataPoint.setWeight(150);
            dataPoint.setCaloriesBurnt(0);
            data.addDataPoint(dataPoint);
        }
        // Getting date to check if weight is unchanged at the end
        long milliseconds = CurrentUser.currentDateEpoch();
        // get current date, then add one to date
        Date finalDate = new Date(milliseconds + 86400000L);

        HashMap<Date, Double> actual = PredictManager.predictWeight(data);
        assertEquals(150, actual.get(finalDate));
    }

    @Test
    public void WeightPredictorOneDataPoint() {
        DataPoint dataPoint = new DataPoint(11, 10, 1971);
        CurrentUser.getInstance().setUser(u);
        dataPoint.setWeight(150);
        dataPoint.setCaloriesBurnt(700);
        DataPointMap data = new DataPointMap();
        data.addDataPoint(dataPoint);

        long milliseconds = CurrentUser.currentDateEpoch();
        // get current date, then add one to date
        Date finalDate = new Date(milliseconds + 86400000L);
        assertEquals(149.8, PredictManager.predictWeight(data).get(finalDate));
    }

    @Test
    public void WeightPredictorManyDataPoints() {
        DataPointMap data = new DataPointMap();
        CurrentUser.getInstance().setUser(u);
        for (int day = 1; day <= 30; day ++) {
            DataPoint dataPoint = new DataPoint(1, day, 2000);
            dataPoint.setWeight(150);

            // Setting calories burned so its different some days
            if (day % 3 == 0) {dataPoint.setCaloriesBurnt(0);}
            else if (day % 3 == 1) {dataPoint.setCaloriesBurnt(350);}
            else {dataPoint.setCaloriesBurnt(700);}

            data.addDataPoint(dataPoint);
        }
        // Getting date to check if weight is unchanged at the end
        long milliseconds = CurrentUser.currentDateEpoch();
        // get current date, then add 30 days to date
        Date finalDate = new Date(milliseconds + 86400000L * 30);

        assertEquals(147, PredictManager.predictWeight(data).get(finalDate));

    }

    @Test
    public void PredictManagerCaloriePredictorEmpty() {
        DataPointMap data = new DataPointMap();
        assertEquals(PredictManager.predictCalories(data), 0.0, 0.01);
    }

    @Test
    public void PredictManagerCaloriePredictorZero() {
        double caloriesBurnt = 0.0;
        DataPointMap data = new DataPointMap();
        DataPointManager manager = new DataPointManager();
        DataPoint input1 = manager.createDataPoint(1, 1, 1);
        input1.setCaloriesBurnt(caloriesBurnt);
        data.addDataPoint(input1);
        assertEquals(PredictManager.predictCalories(data), caloriesBurnt, 0.01);
    }

    @Test
    public void PredictManagerCaloriePredictorOneInput() {
        double caloriesBurnt = 100.5;
        DataPointMap data = new DataPointMap();
        DataPointManager manager = new DataPointManager();
        DataPoint input1 = manager.createDataPoint(1, 1, 1);
        input1.setCaloriesBurnt(caloriesBurnt);
        data.addDataPoint(input1);
        assertEquals(PredictManager.predictCalories(data), caloriesBurnt, 0.01);
    }

    @Test
    public void PredictManagerCaloriePredictorManyInputs() {
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
        assertEquals(PredictManager.predictCalories(data),
                Arrays.stream(caloriesBurnt).sum() / caloriesBurnt.length, 0.01);
    }

}
