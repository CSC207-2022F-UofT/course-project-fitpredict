package entities;
import use_cases.DataPointMap;

import java.io.Serializable;

// This is going to be our User entity.
public class User implements Serializable {

    private String username;
    private String password;
    private String repeatPassword;
    private Double weight;
    private Double height;
    private String sex;
    private String birthday;
    private DataPointMap dataPointMap;

    /**
     * A user with account information.
     *
     * @param username The user's username
     * @param password The user's password
     * @param repeatPassword  The user's repeated password
     * @param weight The user's weight
     * @param height The user's height
     * @param sex The user's sex
     * @param birthday The user's birthday
     */
    public User(String username, String password,String repeatPassword,  Double weight, Double height, String sex,
                String birthday) {
        this.username = username;
        this.password = password;
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.birthday = birthday;
        this.repeatPassword = repeatPassword;
        this.dataPointMap = new DataPointMap();
    }

    public User() {}

    /**
     * Returns the user's username.
     * @return username
     */
    public String getUsername(){
        return username;
    }

    /**
     * Sets the User's username.
     */
    public void setUsername(String username){
        this.username = username;
    }

    /**
     * Returns the user's weight.
     * @return weight
     */
    public Double getWeight(){
        return weight;
    }

    /**
     * Sets the User's weight.
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * Returns the user's height.
     * @return height.
     */
    public Double getHeight(){
        return height;
    }

    /**
     * Sets the user's height
     */
    public void setHeight(Double height) {
        this.height = height;
    }

    /**
     * Returns the user's sex
     * @return sex
     */
    public String getSex(){
        return sex;
    }

    /**
     * Sets the user's sex.
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Returns the User's birthday
     * @return birthday
     */
    public String getBirthday(){
        return birthday;
    }

    /**
     * Return the user's password.
     * @return password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the user's repeated password.
     * @return repeated password
     */
    public String getRepeatPassword() {
        return repeatPassword;
    }

    /**
     * Sets the user's repeated password.
     */
    public void setRepeatPassword(String repeatPassword) {
        this.password = repeatPassword;
    }

    // This function was initially in UserCreation but it should be in the entity file.

    /**
     * Returns true if the two passwords match
     * @return if the two password match
     */
    public boolean checkPasswordMatches(String password) {
        return this.password.equals(password);
    }

    public DataPointMap getDataPointMap() {
        return this.dataPointMap;
    }
}
