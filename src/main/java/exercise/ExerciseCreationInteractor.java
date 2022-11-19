package exercise;

// Use Case

import exercise_screens.ResultScreen;
import java.util.ArrayList;

public class ExerciseCreationInteractor implements ExerciseInputBoundary{
    final ExerciseFactory factory;
    final ExerciseMap map;
    private final User currentUser;

    public ExerciseCreationInteractor (ExerciseFactory factory, ExerciseMap map, User currentUser) {
        this.factory = factory;
        this.map = map;
        this.currentUser = currentUser;
    }

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
        map.addExercise(currentUser, factory.create(name, caloriesBurntPerMin));
        ResultScreen rs = new ResultScreen("Exercise added!");
        rs.setVisible(true);
        return true;
    }

}
