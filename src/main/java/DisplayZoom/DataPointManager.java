package DisplayZoom;

public class DataPointManager {
    /*
    initialize a DataPoint object with the date (month, day, year)
     */
    public DataPoint createDataPoint(int month, int day, int year) {
        return new DataPoint(month, day, year);
    }

    /*
    delete DataPoint from the DataPointMap
     */
    public void deleteDataPoint(DataPoint dp, DataPointMap map) {
        map.removeDataPoint(dp);
    }
}
