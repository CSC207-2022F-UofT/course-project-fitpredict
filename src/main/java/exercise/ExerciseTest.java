package exercise;

public class ExerciseTest {
    public static void main(String[] args) {
        // DO NOT DO THIS - WE DO NOT WANT HUMAN USERS DIRECTLY INSTANTIATING myExercise
        Exercise myExercise = new Exercise("Squats", 8);


        // WE WANT HUMAN USERS TO DO THIS - NOW ALL REQUESTS TO INSTANTIATE myExercise2 ARE HANDLED BY ExerciseTest
        ExerciseManager myExerciseManager = new ExerciseManager();
        Exercise myExercise2 = myExerciseManager.createExercise("Jumping Jacks", 8);
    }
}