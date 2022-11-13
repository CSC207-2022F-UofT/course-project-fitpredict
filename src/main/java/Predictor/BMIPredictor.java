package Predictor;

public class BMIPredictor {

    public DataPointMap predict(DataPointMap data) {
        /*
        This function predicts your BMI based on the weight that you lose over time.
        It simply uses the BMI formula taken from:
        https://www.cdc.gov/nccdphp/dnpao/growthcharts/training/bmiage/page5_1.htm
        Essentially, just dividing your weight in kg by your height in cm^2, then multiplying by 10 000
         */
        HashMap<Integer, DataPoint> dataMap = data.getData();

        // TODO: use WeightPredictor to then calculate your calories burnt, then plug this into
        //   BMI formula

        return data; // placeholder
    }

}
