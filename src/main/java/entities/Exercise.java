package entities;

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

    /**
     * Gets the name of the exercise
     * @return A String of the name of the exercise
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the number of calories burnt per minute while exercising
     * @return A double of the number of calories burnt while exercising
     */
    public double getCaloriesBurntPerMin() {
        return caloriesBurntPerMin;
    }

    /**
     * Sets the name of the exercise
     * @param name The new name of the exercise
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the number of calories burnt per minute while exercising
     * @param caloriesBurntPerMin The new number of calories burnt per minute while exercising
     */
    public void setCaloriesBurntPerMin(double caloriesBurntPerMin) {
        this.caloriesBurntPerMin = caloriesBurntPerMin;
    }
}
