package use_cases;

import java.util.Date;
import java.util.HashMap;

/**
 * Use Case: A class to predict BMI over time
 */
public class BMIPredictor {

    /**
     * Returns a predicted BMI in the future over the days based on the inputted DataPointMap
     *         It simply uses the BMI formula taken from:
     *         <a href="https://www.cdc.gov/nccdphp/dnpao/growthcharts/training/bmiage/page5_1.htm">the CDC</a>
     *         Essentially, just dividing your weight in kg by your height in cm^2, then multiplying by 10 000
     *
     * @param data The data that is used for the prediction
     * @return A hashmap of Dates that map to a Double corresponding to the BMI prediction of that date
     */
    public static HashMap<Date, Double> predict(DataPointMap data) {
        HashMap<Date, Double> dataMap = new HashMap<>();
        // TODO: use WeightPredictor to then calculate your weight loss, then plug this into
        //   BMI formula

        return dataMap; // placeholder
    }

}
