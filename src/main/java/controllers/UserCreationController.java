package controllers;
import use_cases.CreationInputBoundary;
import use_cases.UserAccountList;

import java.util.ArrayList;

public class UserCreationController {
    private final CreationInputBoundary creationInputBoundary;
   //private final UserCreator userCreator;

    /**
     * A creation controller for the use case user-creation to use
     */

    public UserCreationController(CreationInputBoundary creationInputBoundary) {
        this.creationInputBoundary = creationInputBoundary;
    }

    /**
     * Takes the user input, creates an account, and returns an account creation message
     *
     * @param username       The user's username
     * @param password       The user's password
     * @param repeatPassword The user's repeat password
     * @param height         The user's height
     * @param weight         THe user's weight
     * @param sex            The user's sex
     * @param birthday       The user's birthday
     * @return if all user input is valid
     */
    public ArrayList<String> accountCreator(String username, String password, String repeatPassword,
                                            Double height, Double weight, String sex, String birthday) {
        return creationInputBoundary.accountCreator(username, password, repeatPassword, height, weight, sex, birthday);
    }

    public UserAccountList getUserAccountList() {
        return this.creationInputBoundary.getExistingUsers();
    }

}
