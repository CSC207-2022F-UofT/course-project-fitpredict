package exercise;

public interface ExerciseFactory {
    Exercise create(String name, double caloriesBurntPerMin);
}
