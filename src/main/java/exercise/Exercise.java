package exercise;

public class Exercise {
    String name;
    String type;
    float caloriesBurntPerMin;

    /**
     * Constructor
     * Cannot be named "_"
     */
    public Exercise (String name, float caloriesBurntPerMin) {
        this.name = name;
        this.caloriesBurntPerMin = caloriesBurntPerMin;
    }

    /**
     * Constructor 2
     * Cannot be named "_"
     */
    public Exercise (String name, String type, float caloriesBurntPerMin) {
        this.name = name;
        this.type = type;
        this.caloriesBurntPerMin = caloriesBurntPerMin;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public float getCaloriesBurntPerMin() {
        return caloriesBurntPerMin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCaloriesBurntPerMin(float caloriesBurntPerMin) {
        this.caloriesBurntPerMin = caloriesBurntPerMin;
    }
}
