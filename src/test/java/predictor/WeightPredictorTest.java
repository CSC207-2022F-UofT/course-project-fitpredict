package predictor;

import org.junit.jupiter.api.Test;
import use_cases.WeightPredictor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeightPredictorTest {
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