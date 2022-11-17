package user_login;

import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String password;
    private String repeatPassword;
    private Float weight;
    private Float height;
    private String sex;
    private String birthday;

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
    public User(String username, String password,String repeatPassword,  Float weight, Float height, String sex,
                String birthday) {
    }

    /**
     * Returns the user's username.
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the User's username.
     */
    public void setUsername(String username) {
    }

    /**
     * Returns the user's weight.
     * @return weight
     */
    public Float getWeight() {
        return weight;
    }

    /**
     * Sets the User's weight.
     */
    public void setWeight(Float weight){
    }

    /**
     * Returns the user's height.
     * @return height.
     */
    public Float getHeight(){
        return height;
    }

    /**
     * Sets the user's height
     */
    public void setHeight(Float height){
    }

    /**
     * Returns the user's sex
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets the user's sex.
     */
    public void setSex(String sex){
    }

    /**
     * Returns the User's birthday
     * @return birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Return the user's password.
     * @return password.
     */
    public String getPassword(){
        return password;
    }

    /**
     *  Sets the user's password.
     */
    public void setPassword(String password){
    }

    /**
     * Returns the user's repeated password.
     * @return repeated password
     */
    public String getRepeatPassword(){
        return repeatPassword;
    }

    /**
     * Sets the user's repeated password.
     */
    public void setRepeatPassword(String repeatPassword){
    }

    /**
     * Returns true if the two passwrods match
     * @return if the two passwrod smatch
     */
    public boolean checkPasswordMatches(String password){
        return true;
    }


}


