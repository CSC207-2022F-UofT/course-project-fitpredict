package predictor;

import entities.CurrentUser;
import entities.User;
import org.junit.jupiter.api.Test;
import use_cases.BMIPredictor;
import use_cases.DataPointMap;
import use_cases.WeightPredictor;
import use_cases.DataPointMap;
import entities.DataPoint;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeightPredictorTest {
    User u = new User("Josh", "123abc", "123abc",
            62.0, 150.0, "Male", "2006-10-12");

    @Test
    public void testWeightPredictorZero() {
        DataPointMap data = new DataPointMap();
        // Assert that the return type is empty
        assertEquals(0, WeightPredictor.predict(data).size());
    }

    @Test
    public void testWeightPredictorCalorieDeficitZero() {
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

        HashMap<Date, Double> actual = WeightPredictor.predict(data);
        assertEquals(150, actual.get(finalDate));
    }

    @Test
    public void testWeightPredictorOneDataPoint() {
        DataPoint dataPoint = new DataPoint(11, 10, 1971);
        CurrentUser.getInstance().setUser(u);
        dataPoint.setWeight(150);
        dataPoint.setCaloriesBurnt(700);
        DataPointMap data = new DataPointMap();
        data.addDataPoint(dataPoint);

        long milliseconds = CurrentUser.currentDateEpoch();
        // get current date, then add one to date
        Date finalDate = new Date(milliseconds + 86400000L);
        assertEquals(149.8, WeightPredictor.predict(data).get(finalDate));
    }

    @Test
    public void testWeightPredictorManyDataPoints() {
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

        assertEquals(147, WeightPredictor.predict(data).get(finalDate));

    }
}
