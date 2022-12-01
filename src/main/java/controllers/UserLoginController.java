package controllers;

import entities.CurrentUser;
import use_cases.LoginInputBoundary;
import use_cases.UserAccountList;
import use_cases.UserLogin;

public class UserLoginController {
    private final LoginInputBoundary loginInputBoundary;
    private CurrentUser currentUser;

    /**
     * A Login Controller for the use case UserLogin to use.
     */
    public UserLoginController(LoginInputBoundary loginInputBoundary) {
        this.loginInputBoundary = loginInputBoundary;
    }

    /**
     * Takes the user's username and password and logs them in.
     * @param username The user's username.
     * @param password The user's password.
     */
    public UserLogin.LogInResult login(String username, String password) {
        return loginInputBoundary.loginUser(username, password);
    }

    public UserAccountList getUserAccountList(){
        return this.loginInputBoundary.getUserAccountList();
    }
}
