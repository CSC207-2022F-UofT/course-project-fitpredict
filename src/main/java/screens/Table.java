package screens;

import use_cases.DataPointMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Table class - framework/driver
 */
public class Table implements VisualUnit {
    /**
     * generate an array with table values to be displayed
     * @param data DataPointMap to be displayed on the table
     * @return 2D array to be displayed on UI
     */
    public static Object[][] generate(DataPointMap data) {
        // error handling for the event that a user finds an exploit to get to this screen without logging in
        if (data == null) {
            return new Object[1][3];
        }

        Object[][] tableFormat = new Object[data.getData().keySet().size()][3];

//        information: the table headers are the following: {
//                "Date",
//                "Weight",
//                "Calories Burnt"
//        }

        ArrayList<Date> dates = new ArrayList<Date>(data.getData().keySet());
        Collections.sort(dates);
        int i = 0;
        for (Date date : dates) {
            tableFormat[i] = new Object[]{date.toString(),
                    String.valueOf(data.getDataPoint(date).getWeight()),
                    String.valueOf(data.getDataPoint(date).getCaloriesBurnt())};
            i += 1;
        }

        return tableFormat;
    }

//    public void generate(DataPointMap data, Date date) {
//
//    }
//    public void generateSample(DataPointMap sampleData) {
//
//    }
//    public void zoomIn(DataPoint dataPoint) {
//
//    }
}