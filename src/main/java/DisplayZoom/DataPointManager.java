package DisplayZoom;

/*
DataPointManager class
 */
public class DataPointManager {
    /*
    initialize a DataPoint object with the date (month, day, year)
     */
    public DataPoint createDataPoint(int month, int day, int year) {
        return new DataPoint(month, day, year);
    }
}
