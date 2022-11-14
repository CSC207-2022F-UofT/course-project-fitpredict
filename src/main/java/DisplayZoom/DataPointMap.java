package DisplayZoom;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.HashMap;

public class DataPointMap {
    HashMap<Date, DataPoint> dataPointMap;

    public DataPointMap(ArrayList<DataPoint> dataPoints) {
        //TODO: create dataPointMap HashMap using DataPoint.getDate()
    }

    public HashMap<Date, DataPoint> getData() {
        return this.dataPointMap;
    }

    public DataPoint getDataPoint(Date date) {
        DataPoint dataPoint();
        //TODO: complete for loop to find DataPoint with the matching date attribute in dataPointMap
        return dataPoint;
    }
}
