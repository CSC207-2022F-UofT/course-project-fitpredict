package use_cases;

// Use Case

import entities.Exercise;
import screens.ResultScreen;
import java.util.ArrayList;

public class ExerciseCreationInteractor implements ExerciseInputBoundary {
    final ExerciseManager manager;
    final ExerciseMap map;
    private final User currentUser;

    /**
     * Constructor
     * @param manager Used to create exercises
     * @param map Needed to add the exercise and map it to the user
     * @param currentUser The user currently logged in who may create a new exercise
     */
    public ExerciseCreationInteractor (ExerciseManager manager, ExerciseMap map, User currentUser) {
        this.manager = manager;
        this.map = map;
        this.currentUser = currentUser;
    }

    /**
     * Creates and assigns a new exercise to the currently logged in user
     * @param name The name of the new exercise
     * @param caloriesBurntPerMin The number of calories burnt per minute while engaging in the new exercise
     * @return Returns a boolean representing if the exercise was successfully created
     */
    @Override
    public boolean create(String name, double caloriesBurntPerMin) {
//        if (map.contains(currentUser.getName())) {
//            ArrayList<Exercise> exerciseList = map.get(currentUser.getName());
//            for (Exercise exercise : exerciseList) {
//                if (exercise.getName().equals(name)) {
//                    ResultScreen rs = new ResultScreen("An Exercise with that name already exists!");
//                    rs.setVisible(true);
//                    return false;
//                }
//            }
//            exerciseList.ad(factory.create(name, caloriesBurntPerMin));
//            ResultScreen rs = new ResultScreen("Exercise added!");
//            rs.setVisible(true);
//            return true;
//        }
//        this.map.put(currentUser.getName(), factory.create(name, caloriesBurntPerMin));
//        ResultScreen rs = new ResultScreen("Exercise added!");
//        rs.setVisible(true);
//        return true;
        if (map.contains(currentUser.getName())) {
            ArrayList<Exercise> exerciseList = map.get(currentUser.getName());
            for (Exercise exercise : exerciseList) {
                if (exercise.getName().equals(name)) {
                    ResultScreen rs = new ResultScreen("An Exercise with that name already exists!");
                    rs.setVisible(true);
                    return false;
                }
            }
        }
        map.addExercise(currentUser, manager.createExercise(name, caloriesBurntPerMin));
        ResultScreen rs = new ResultScreen("Exercise added!");
        rs.setVisible(true);
        return true;
    }

}
