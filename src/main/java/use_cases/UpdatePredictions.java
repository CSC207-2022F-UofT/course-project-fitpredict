package use_cases;

import entities.CurrentUser;
import entities.DataPoint;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UpdatePredictions {

    /**
     * A class that updates the currently logged-in user's predictions.
     * There are no inputs to this class - it uses static methods to get the logged in user's data and updates it in a
     *  similar manner.
     */
    public static void updateDashboardPredictions() {
        DataPointMap data = CurrentUser.getInstance().getUser().getDataPointMap();
        HashMap<Date, Double> weightPredictions = PredictManager.predictWeight(data);
        double caloriePrediction = PredictManager.predictCalories(data);
        DataPointManager dataPointManager = new DataPointManager();

        DataPointMap predictionMap = new DataPointMap();
        // loop through weightPredictions
        for (Map.Entry<Date, Double> entry: weightPredictions.entrySet()) {
            Date date = entry.getKey();

            DataPoint tempDataPoint = dataPointManager.createDataPoint(date);
            tempDataPoint.setWeight(weightPredictions.get(date));
            tempDataPoint.setCaloriesBurnt(caloriePrediction);
            predictionMap.addDataPoint(tempDataPoint);
        }
        data.mergeDataPoints(predictionMap.getData());

    }
}
