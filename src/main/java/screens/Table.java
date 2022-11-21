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
        Object[][] tableFormat = new Object[data.getData().keySet().size()][3];

//        String[] table_headers = {
//                "Date",
//                "Weight",
//                "Calories Burnt"
//        };

        ArrayList<Date> dates = new ArrayList<Date>(data.getData().keySet());
        Collections.sort(dates);
        int i = 0;
        for (Date date : dates) {
            tableFormat[i] = {date.toString(),
                            data.getDataPoint(date).getWeight().toString(),
                            data.getDataPoint(date).getCaloriesBurnt().toString()};
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