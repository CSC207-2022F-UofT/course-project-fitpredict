package exercise;

//Entity

public class Exercise {
    String name;
    double caloriesBurntPerMin;

    /**
     * Constructor
     * @param name The name of the exercise, cannot be named "_"
     * @param caloriesBurntPerMin The number of calories burnt per minute while engaging in this exercise
     */
    public Exercise (String name, double caloriesBurntPerMin) {
        this.name = name;
        this.caloriesBurntPerMin = caloriesBurntPerMin;
    }

    public String getName() {
        return name;
    }

    public double getCaloriesBurntPerMin() {
        return caloriesBurntPerMin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCaloriesBurntPerMin(double caloriesBurntPerMin) {
        this.caloriesBurntPerMin = caloriesBurntPerMin;
    }
}
