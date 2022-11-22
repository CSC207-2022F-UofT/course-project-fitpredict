/*
 * This file contains JUnit test cases for DataPoint.java
 */

package display_zoom;
import entities.DataPoint;
import entities.Exercise;
import org.junit.*;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DataPointTest {
    DataPoint dp;
    Exercise exercise1;
    Exercise exercise2;
    Exercise exercise3;
    ArrayList<Exercise> exercises = new ArrayList<>();
    ArrayList<Exercise> exercisesEmpty = new ArrayList<>();

    @Before
    public void setUp() {
        dp = new DataPoint(1, 1, 2022);
        exercise1 = new Exercise("walking", 1.0);
        exercise2 = new Exercise("running", 7);
        exercise3 = new Exercise("jumping", 10);
        exercises.add(exercise1);
        exercises.add(exercise3);

    }

    @After
    public void tearDown() {
    }

    @Test(timeout = 50)
    public void testConvertEpochSecondsBeginning() {
        long actual = DataPoint.convertEpochSeconds(1, 1, 1970);
        long expected = 0;
        assertEquals(actual, expected);
    }

    @Test(timeout = 50)
    public void testConvertEpochSecondsLaterDate() {
        long actual = DataPoint.convertEpochSeconds(11, 21, 2022);
        long expected = 1669006800;
        assertEquals(actual, expected);
    }

    @Test(timeout = 50)
    public void testAddExercise() {
        dp.addExercise(exercise2);
        int actual = dp.getExerciseList().size();
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test(timeout = 50)
    public void testAddExerciseMultiple() {
        dp.addExercise(exercises);
        int actual = dp.getExerciseList().size();
        int expected = 3;
        assertEquals(actual, expected);
    }

    @Test(timeout = 50)
    public void testAddExerciseEmptyList() {
        dp.addExercise(exercisesEmpty);
        int actual = dp.getExerciseList().size();
        int expected = 3;
        assertEquals(actual, expected);
    }


}
