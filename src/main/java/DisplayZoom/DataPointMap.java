package DisplayZoom;
import java.util.*;
import java.util.HashMap;

/*
DataPointMap class : Mapping of Date objects to DataPoint objects
 */
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
        this.dataPointMap.put(dp.getDate(), dp); // if the date is already mapped to a DataPoint, then
                                                // over-write that DataPoint with this new one
                                                // if it is not, then create a new element in the hashmap
    }

    /*
    setter function to delete a DataPoint object from the DataPointMap
     */
    public void removeDataPoint(DataPoint dp) {
        if (this.getDataPoint(dp.getDate()) != null) {
            this.dataPointMap.remove(dp.getDate(), dp); // only remove it if the DataPoint exists in the DataPointMap
        }
    }
}
