package use_cases;
import entities.DataPoint;

import java.util.*;
import java.util.HashMap;

/**
 * DataPointMap use case - Mapping of Date objects to DataPoint objects
 */
public class DataPointMap {
    private HashMap<Date, DataPoint> dataPointMap = new HashMap<Date, DataPoint>();

    /**
     * Gets the dataPointMap
     * @return dataPointMap
     */
    public HashMap<Date, DataPoint> getData() {
        return this.dataPointMap;
    }

    /**
     * Gets the DataPoint object in the DataPointMap with the corresponding Date
     * returns null if a DataPoint with that corresponding date does not exist in the DataPointMap
     * @param date Date of DataPoint
     * @return DataPoint
     */
    public DataPoint getDataPoint(Date date) {
        for (Date d: this.getData().keySet()) {
            if (d.compareTo(date) == 0) { // if the dates are the same, then compareTo() returns 0
                return this.getData().get(d);
            }
        }
        return null; // return null if dataPoint is not found
    }

    /**
     * merge a HashMap of Date objects mapped to DataPoint objects and a DataPointMap object
     * @param map HashMap to be merged with dataPointMap
     */
    public void mergeDataPoints(HashMap<Date, DataPoint> map) {
        for (Date date : map.keySet()) {
            this.dataPointMap.put(date, map.get(date));
        }
    }

    /**
     * add a DataPoint object to the DataPointMap
     * @param dp DataPoint to be added to DataPointMap
     */
    public void addDataPoint(DataPoint dp) {
        // if the date is already mapped to a DataPoint, then over-write that DataPoint with this new one
        // if it is not, then create a new element in the hashmap
        this.dataPointMap.put(dp.getDate(), dp);
    }

    /**
     * delete a DataPoint object from the DataPointMap
     * @param dp DataPoint to be deleted
     */
    public void removeDataPoint(DataPoint dp) {
        if (this.getDataPoint(dp.getDate()) != null) {
            this.dataPointMap.remove(dp.getDate(), dp); // only remove it if the DataPoint exists in the DataPointMap
        }
    }
}
