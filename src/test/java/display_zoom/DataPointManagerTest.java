/*
 * This file contains JUnit test cases for DataPointManagerTest.java
 */

package display_zoom;
import entities.DataPoint;
import org.junit.*;
import use_cases.DataPointManager;

import static org.junit.Assert.assertEquals;

public class DataPointManagerTest {
    DataPointManager dpManager = new DataPointManager();

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test(timeout = 50)
    public void testCreateDataPoint() {
        DataPoint dp = dpManager.createDataPoint(11, 21, 2022);
        boolean actual = dp instanceof DataPoint;
        boolean expected = true;
        assertEquals(actual, expected);
    }

    @Test(timeout = 50)
    public void testCreateDataPoint1InvalidArgument() {
        boolean thrown = false;
        try {
            dpManager.createDataPoint(13, 21, 2022);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        boolean expected = true;
        assertEquals(thrown, expected);
    }

    @Test(timeout = 50)
    public void testCreateDataPointMultipleInvalidArguments() {
        boolean thrown = false;
        try {
            dpManager.createDataPoint(20, 0, -1);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        boolean expected = true;
        assertEquals(thrown, expected);
    }

    @Test(timeout = 50)
    public void testCheckValidInputValid() {
        boolean thrown = false;
        try {
            dpManager.createDataPoint(12, 14, 2001);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        boolean expected = false;
        assertEquals(thrown, expected);
    }

    @Test(timeout = 50)
    public void testCheckValidInputInvalidMonth() {
        boolean thrown = false;
        try {
            dpManager.createDataPoint(0, 14, 2001);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        boolean expected = true;
        assertEquals(thrown, expected);
    }

    @Test(timeout = 50)
    public void testCheckValidInputInvalidDay() {
        boolean thrown = false;
        try {
            dpManager.createDataPoint(12, 32, 2001);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        boolean expected = true;
        assertEquals(thrown, expected);
    }

    @Test(timeout = 50)
    public void testCheckValidInputInvalidYear() {
        boolean thrown = false;
        try {
            dpManager.createDataPoint(12, 14, 0);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        boolean expected = true;
        assertEquals(thrown, expected);
    }
}