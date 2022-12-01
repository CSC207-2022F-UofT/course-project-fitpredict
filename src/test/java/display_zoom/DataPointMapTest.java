/*
 * This file contains JUnit test cases for DataPointMap.java
 */

package display_zoom;
import entities.DataPoint;
import org.junit.*;
import use_cases.DataPointMap;

import java.io.*;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class DataPointMapTest {
    DataPointMap map = new DataPointMap();
    DataPoint dp1;
    DataPoint dp2;
    DataPoint dp3;
    Date date;
    HashMap<Date, DataPoint> mapToMerge = new HashMap<>();
    HashMap<Date, DataPoint> mapEmpty = new HashMap<>();

    @Before
    public void setUp() {
        dp1 = new DataPoint(11, 10, 2022);
        dp2 = new DataPoint(11, 11, 2022);
        dp3 = new DataPoint(11, 12, 2022);

        long seconds1 = DataPoint.convertEpochMilliseconds(11, 10, 2022);
        date = new Date(seconds1);

        mapToMerge.put(dp2.getDate(), dp2);
    }

    @After
    public void tearDown() {
    }

    @Test(timeout = 50)
    public void testAddDataPoint() {
        map.addDataPoint(dp1);
        int actual = map.getData().size();
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test(timeout = 50)
    public void testGetDataPoint() {
        map.addDataPoint(dp1);
        String actual = map.getDataPoint(date).getDate().toString();
        String expected = date.toString();
        assertEquals(actual, expected);
    }

    @Test(timeout = 50)
    public void testMergeDataPoints() {
        map.mergeDataPoints(mapToMerge);
        int actual = map.getData().size();
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test(timeout = 50)
    public void testMergeDataPointsEmptyMap() {
        map.mergeDataPoints(mapEmpty);
        int actual = map.getData().size();
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test(timeout = 50)
    public void testRemoveDataPoint() {
        map.addDataPoint(dp1);
        map.removeDataPoint(dp1);
        int actual = map.getData().size();
        int expected = 0;
        assertEquals(actual, expected);
    }
}
