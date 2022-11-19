package exercise;

// Entity

public class ExerciseFactory {
    public Exercise create(String name, double calories) {
        return new Exercise(name, calories);
    }
}
