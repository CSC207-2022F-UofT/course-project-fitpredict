package user_login;

import entities.CurrentUser;

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
}
