package DisplayView;

//import DisplayZoom.DataPoint;
//import DisplayZoom.DataPointMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Table implements VisualUnit {
    public Object[][] generate(DataPointMap data) {
        Object[][] tableFormat = new Object[data.getData().keySet().size()][3];

//        String[] table_headers = {
//                "Date",
//                "Weight",
//                "Calories Burnt"
//        };

        ArrayList<Date> dates = new ArrayList<Date>(data.getData.keySet());
        ArrayList<Date> sorted_dates = Collections.sort(dates);
        int i = 0;
        for (Date date : sorted_dates) {
            tableFormat[i] = {date.toString(),
                            data.getDataPoint(date).getWeight().toString(),
                            data.getDataPoint(date).getCaloriesBurnt().toString()};
            i += 1;
        }

        return tableFormat;
    }
//
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