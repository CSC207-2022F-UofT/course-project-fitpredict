package exercise;

public class Exercise {
    String name;
    double caloriesBurntPerMin;

    /**
     * Constructor
     * Cannot be named "_"
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

    public void setCaloriesBurntPerMin(float caloriesBurntPerMin) {
        this.caloriesBurntPerMin = caloriesBurntPerMin;
    }
}
