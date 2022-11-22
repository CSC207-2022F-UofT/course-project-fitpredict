package predictor;

import org.junit.jupiter.api.Test;
import use_cases.WeightPredictor;
import use_cases.DataPointMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PredictManagerTest {
    @Test
    public void PredictManagerBMIPredictorZero() {
        // similar to BMIPredictor test, but that the manager also returns a correct value
    }

    @Test
    public void PredictManagerBMIPredictorNoChange() {
        // test that the BMI predictor knows when not to change
        // TODO: when this function is implemented, write a test case
        // because at the moment, it cannot properly be written
    }

    @Test
    public void PredictManagerBMIPredictorSmallData() {
        // TODO: when this function is implemented, write a test case
        // because at the moment, it cannot properly be written
    }

    @Test
    public void PredictManagerBMIPredictorBigData() {
        // TODO: when this function is implemented, write a test case
        // because at the moment, it cannot properly be written
    }

    @Test
    public void PredictManagerWeightPredictorZero() {
        // similar to WeightPredictor test, but that the manager also returns a correct value
        DataPointMap data = new DataPointMap();
        // Assert that the return type is empty
        assertEquals(WeightPredictor.predict(data).size(), 0);
    }

    @Test
    public void PredictManagerWeightPredictorNoChange() {
        // test that the Weight predictor knows when not to change
        // TODO: when this function is implemented, write a test case
        // because at the moment, it cannot properly be written
    }

    @Test
    public void PredictManagerWeightPredictorSmallData() {
        // TODO: when this function is implemented, write a test case
        // because at the moment, it cannot properly be written
    }

    @Test
    public void PredictManagerWeightPredictorBigData() {
        // TODO: when this function is implemented, write a test case
        // because at the moment, it cannot properly be written
    }
}
