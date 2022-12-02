/*
 * This file contains JUnit test cases for DataPoint.java
 */

package display_zoom;
import entities.DataPoint;
import entities.Exercise;
import org.junit.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

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
        dp.setWeight(100);
        dp.setCaloriesBurnt(500);
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
    public void testConvertEpochMillisecondsBeginning() {
        long actual = DataPoint.convertEpochMilliseconds(1, 1, 1970);
        long expected = 0;
        assertEquals(actual, expected);
    }

    @Test(timeout = 50)
    public void testConvertEpochMillisecondsLaterDate() {
        long actual = DataPoint.convertEpochMilliseconds(11, 21, 2022);
        long expected = 1668988800000L;
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
        int expected = 2;
        assertEquals(actual, expected);
    }

    @Test(timeout = 50)
    public void testAddExerciseEmptyList() {
        dp.addExercise(exercisesEmpty);
        int actual = dp.getExerciseList().size();
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test(timeout = 50)
    public void testGetDate() {
        Date date = new Date(DataPoint.convertEpochMilliseconds(1, 1, 2022));
        int actual = dp.getDate().compareTo(date);
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test(timeout = 50)
    public void testGetExerciseListEmpty() {
        int actual = dp.getExerciseList().size();
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test(timeout = 50)
    public void testGetExerciseListNonEmpty() {
        dp.addExercise(exercise1);
        int actual = dp.getExerciseList().size();
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test(timeout = 50)
    public void testGetCaloriesBurnt() {
        double actual = dp.getCaloriesBurnt();
        double expected = 500;
        assertEquals(actual, expected, 0.0001);
    }

    @Test(timeout = 50)
    public void testGetWeight() {
        double actual = dp.getWeight();
        double expected = 100;
        assertEquals(actual, expected, 0.0001);
    }

    @Test(timeout = 50)
    public void testSetCaloriesBurnt() {
        dp.setCaloriesBurnt(150);
        double actual = dp.getCaloriesBurnt();
        double expected = 150;
        assertEquals(actual, expected, 0.0001);
    }

    @Test(timeout = 50)
    public void testSetWeight() {
        dp.setWeight(50);
        double actual = dp.getWeight();
        double expected = 50;
        assertEquals(actual, expected, 0.0001);
    }

}
