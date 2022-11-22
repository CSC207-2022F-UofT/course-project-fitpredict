package predictor;

import org.junit.jupiter.api.Test;
import use_cases.WeightPredictor;
import use_cases.DataPointMap;
import entities.DataPoint;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeightPredictorTest {
    @Test
    public void WeightPredictorZero() {
        DataPointMap data = new DataPointMap();
        // Assert that the return type is empty
        assertEquals(0, WeightPredictor.predict(data).size());
    }

    @Test
    public void WeightPredictorCalorieDeficitZero() {
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

        assertEquals(150, WeightPredictor.predict(data).get(finalDate));
    }

    @Test
    public void WeightPredictorOneDataPoint() {
        DataPoint dataPoint = new DataPoint(11, 10, 1971);
        Date date = dataPoint.getDate();
        dataPoint.setWeight(150);
        dataPoint.setCaloriesBurnt(700);
        DataPointMap data = new DataPointMap();
        data.addDataPoint(dataPoint);
        assertEquals(149.8, WeightPredictor.predict(data).get(date));
    }

    @Test
    public void WeightPredictorManyDataPoints() {
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

        assertEquals(147, WeightPredictor.predict(data).get(finalDate));

    }
}
