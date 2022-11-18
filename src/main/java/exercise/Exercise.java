package exercise;

public class Exercise {
    String name;
    float caloriesBurntPerMin;

    /**
     * Constructor
     * Cannot be named "_"
     */
    public Exercise (String name, float caloriesBurntPerMin) {
        this.name = name;
        this.caloriesBurntPerMin = caloriesBurntPerMin;
    }

    public String getName() {
        return name;
    }

    public float getCaloriesBurntPerMin() {
        return caloriesBurntPerMin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCaloriesBurntPerMin(float caloriesBurntPerMin) {
        this.caloriesBurntPerMin = caloriesBurntPerMin;
    }
}
