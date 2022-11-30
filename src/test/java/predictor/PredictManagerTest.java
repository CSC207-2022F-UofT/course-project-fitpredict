package predictor;

import entities.CurrentUser;
import entities.DataPoint;
import entities.User;
import org.junit.jupiter.api.Test;
import use_cases.*;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PredictManagerTest {
    DataPointManager manager = new DataPointManager();
    // create a current user with weight 100kg, height 100cm
    User user = new CurrentUser("mooga", "123",
            "123", 100.0, 101.0, "Male", "");

    @Test
    public void  PredictManagerBMIPredictorEmpty() {
        DataPointMap data = new DataPointMap();
        CurrentUser.getInstance().setUser(user);
        // Assert that the function works with an empty DataPointMap(), BMI should be exactly the same as CurrentUser
        Date new_date = new Date(DataPoint.convertEpochMilliseconds(1, 1, 1));
        assertEquals(PredictManager.predictBMI(data).get(new_date), 100.0, 0.1);
    }

    @Test
    public void  PredictManagerBMIPredictorAllZeroes() {
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
        CurrentUser.getInstance().setUser(user);
        // expected value is: (100 / (101^2)) * 10000 ~ 98.03
        Date new_date = new Date(DataPoint.convertEpochMilliseconds(1, 1, 4));
        assertEquals(PredictManager.predictBMI(data).get(new_date), 98.03, 0.1);
    }

    @Test
    public void  PredictManagerBMIPredictorNoChange() {
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
        CurrentUser.getInstance().setUser(user);
        // expected value is: (100 / (101^2)) * 10000 ~ 98.03
        Date new_date = new Date(DataPoint.convertEpochMilliseconds(1, 1, 4));
        assertEquals(PredictManager.predictBMI(data).get(new_date), 98.03, 0.1);

    }

    @Test
    public void  PredictManagerBMIPredictorOneData() {
        double caloriesBurnt = 7700.0; // this is how many calories it takes to burn 1kg of fat
        DataPointMap data = new DataPointMap();
        // create a current user with weight 100kg, height 100cm
        DataPoint input = manager.createDataPoint(1, 1, 1);
        input.setCaloriesBurnt(caloriesBurnt);
        data.addDataPoint(input);
        CurrentUser.getInstance().setUser(user);
        // expected value is: (99 / (101^2)) * 10000 ~ 97.05
        Date new_date = new Date(DataPoint.convertEpochMilliseconds(1, 1, 2));
        assertEquals(PredictManager.predictBMI(data).get(new_date), 97.05, 0.1);
    }

    @Test
    public void  PredictManagerBMIPredictorMultData() {
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
        CurrentUser.getInstance().setUser(user);
        // expected value is: (97.5 / (101^2)) * 10000 ~ 95.1
        Date newDate = new Date(DataPoint.convertEpochMilliseconds(1, 1, 2));
        assertEquals(PredictManager.predictBMI(data).get(newDate), 95.14, 0.1);
    }

    @Test
    public void PredictManagerWeightPredictorEmpty() {
        DataPointMap data = new DataPointMap();
        // Assert that the function works with an empty DataPointMap()
        CurrentUser user = new CurrentUser("mooga", "123",
                "123", 100.0, 101.0, "Male", "");
        // Assert that the function works with an empty DataPointMap(), Weight should be exactly the same as CurrentUser
        assertEquals(BMIPredictor.predict(data).size(), 100.0);
    }

    @Test
    public void PredictManagerWeightPredictorZero() {
        DataPointMap data = new DataPointMap();
        // Assert that the return type is empty
        assertEquals(0, WeightPredictor.predict(data).size());
    }

    @Test
    public void PredictManagerWeightPredictorCalorieDeficitZero() {
        DataPointMap data = new DataPointMap();
        for (int day = 1; day <= 10; day ++) {
            DataPoint dataPoint = new DataPoint(1, day, 2000);
            dataPoint.setWeight(150);
            dataPoint.setCaloriesBurnt(0);
            data.addDataPoint(dataPoint);
        }
        // Getting final date to check if weight is unchanged at the end
        LocalDate milliseconds = LocalDate.of(2000, 1, 10);
        Date finalDate = new Date(milliseconds.toEpochDay());

        assertEquals(150, PredictManager.predictWeight(data).get(finalDate));
    }

    @Test
    public void PredictManagerWeightPredictorOneDataPoint() {
        DataPoint dataPoint = new DataPoint(11, 10, 1971);
        Date date = dataPoint.getDate();
        dataPoint.setWeight(150);
        dataPoint.setCaloriesBurnt(700);
        DataPointMap data = new DataPointMap();
        data.addDataPoint(dataPoint);
        assertEquals(149.8, PredictManager.predictWeight(data).get(date));
    }

    @Test
    public void PredictManagerWeightPredictorManyDataPoints() {
        DataPointMap data = new DataPointMap();
        for (int day = 1; day <= 30; day ++) {
            DataPoint dataPoint = new DataPoint(1, day, 2000);
            dataPoint.setWeight(150);

            // Setting calories burned so its different some days
            if (day % 3 == 0) {dataPoint.setCaloriesBurnt(0);}
            else if (day % 3 == 1) {dataPoint.setCaloriesBurnt(350);}
            else {dataPoint.setCaloriesBurnt(700);}

            data.addDataPoint(dataPoint);
        }
        // Getting final date to check if weight is as expected
        LocalDate milliseconds = LocalDate.of(2000, 1, 30);
        Date finalDate = new Date(milliseconds.toEpochDay());

        assertEquals(147, PredictManager.predictWeight(data).get(finalDate));

    }
}
