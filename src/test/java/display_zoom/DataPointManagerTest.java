/*
 * This file contains JUnit test cases for DataPointManagerTest.java
 */

package display_zoom;
import entities.DataPoint;
import org.junit.*;
import use_cases.DataPointManager;

import static org.junit.Assert.assertEquals;

public class DataPointManagerTest {
    DataPointManager dpManager;

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
}