package DisplayZoom;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.HashMap;

public class DataPointMap {
    private HashMap<Date, DataPoint> dataPointMap;

    public DataPointMap(ArrayList<DataPoint> dataPoints) {
    }

    /*
    Getter function that returns the HashMap of Date objects mapped to their DataPoint objects
     */
    public HashMap<Date, DataPoint> getData() {
        return this.dataPointMap;
    }

    /*
    Getter function that returns the DataPoint object in the DataPointMap with the corresponding Date
    returns null if a DataPoint with that corresponding date does not exist in the DataPointMap
     */
    public DataPoint getDataPoint(Date date) {
        for (Date d: this.getData().keySet()) {
            if (d.compareTo(date) == 0) { // if the dates are the same, then compareTo() returns 0
                return this.getData().get(d);
            }
        }
        return null; // return null if dataPoint is not found
    }

    /*
    setter function to add a DataPoint object to the DataPointMap
     */
    public void addDataPoint(DataPoint dp) {
        this.dataPointMap.put(dp.getDate(), dp);
    }

    /*
    setter function to delete a DataPoint object from the DataPointMap
     */
    public void deleteDataPoint(DataPoint dp) {
        this.dataPointMap.remove(dp.getDate(), dp);
    }
}
