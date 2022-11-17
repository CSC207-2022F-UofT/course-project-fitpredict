package Predict;

import java.util.Date;

/*
    Use Case: A class to predict BMI over time
*/
public class BMIPredictor {

    /*
        Returns a predicted BMI in the future over the days based on the inputted DataPointMap
        It simply uses the BMI formula taken from:
        https://www.cdc.gov/nccdphp/dnpao/growthcharts/training/bmiage/page5_1.htm
        Essentially, just dividing your weight in kg by your height in cm^2, then multiplying by 10 000
    */
    public static DataPointMap predict(DataPointMap data) {
        HashMap<Date, DataPoint> dataMap = data.getData();

        return data; // placeholder
    }
}