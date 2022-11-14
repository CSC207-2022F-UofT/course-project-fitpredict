package DisplayZoom;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.HashMap;

public class DataPointMap {
    private HashMap<Date, DataPoint> dataPointMap;

    public DataPointMap(ArrayList<DataPoint> dataPoints) {
    }

    public HashMap<Date, DataPoint> getData() {
        return this.dataPointMap;
    }

    public DataPoint getDataPoint(Date date) {
        for (Date d: this.getData().keySet()) {
            if (d.compareTo(date) == 0) { // if the dates are the same, then compareTo() returns 0
                return this.getData().get(d);
            }
        }
        return null; // return null if dataPoint is not found
    }
}
