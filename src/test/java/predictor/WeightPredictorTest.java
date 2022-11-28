package predictor;

import entities.CurrentUser;
import org.junit.jupiter.api.Test;
import use_cases.BMIPredictor;
import use_cases.DataPointMap;
import use_cases.WeightPredictor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeightPredictorTest {
    @Test
    public void WeightPredictorEmpty() {
        DataPointMap data = new DataPointMap();
        // Assert that the function works with an empty DataPointMap()
        CurrentUser user = new CurrentUser("mooga", "123",
                "123", 100.0, 101.0, "Male", "");
        // Assert that the function works with an empty DataPointMap(), Weight should be exactly the same as CurrentUser
        assertEquals(BMIPredictor.predict(data).size(), 100.0);
    }

    @Test
    public void WeightPredictorZero() {
        DataPointMap data = new DataPointMap();
        // Assert that the return type is empty
        assertEquals(WeightPredictor.predict(data).size(), 0);
    }

    @Test
    public void WeightPredictorNoChange() {
        // test that the Weight predictor knows when not to change
        // TODO: when this function is implemented, write a test case
        // because at the moment, it cannot properly be written
    }

    @Test
    public void WeightPredictorSmallData() {
        // TODO: when this function is implemented, write a test case
        // because at the moment, it cannot properly be written
    }

    @Test
    public void WeightPredictorBigData() {
        // TODO: when this function is implemented, write a test case
        // because at the moment, it cannot properly be written
    }
}
