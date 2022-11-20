package predictor;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BMIPredictorTest {
    @Test
    public void BMIPredictorZero() {
        DataPointMap data = new DataPointMap();
        // Assert that the return type is empty
        assertEquals(BMIPredictor.predict(data).size(), 0);
    }

    @Test
    public void BMIPredictorNoChange() {
        // test that the BMI predictor knows when not to change
        // TODO: when this function is implemented, write a test case
        // because at the moment, it cannot properly be written
    }

    @Test
    public void BMIPredictorSmallData() {
        // TODO: when this function is implemented, write a test case
        // because at the moment, it cannot properly be written
    }

    @Test
    public void BMIPredictorBigData() {
        // TODO: when this function is implemented, write a test case
        // because at the moment, it cannot properly be written
    }
}
