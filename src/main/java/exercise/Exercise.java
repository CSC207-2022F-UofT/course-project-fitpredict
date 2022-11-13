package exercise;

public class Exercise {
    String name;
    String type;
    int caloriesBurntPerMin;

    /**
     * Constructor
     * Cannot be named "_"
     */
    public Exercise (String name, int caloriesBurntPerMin) {
        this.name = name;
        this.caloriesBurntPerMin = caloriesBurntPerMin;
    }

    /**
     * Constructor 2
     * Cannot be named "_"
     */
    public Exercise (String name, String type, int caloriesBurntPerMin) {
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

    public int getCaloriesBurntPerMin() {
        return caloriesBurntPerMin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCaloriesBurntPerMin(int caloriesBurntPerMin) {
        this.caloriesBurntPerMin = caloriesBurntPerMin;
    }
}
