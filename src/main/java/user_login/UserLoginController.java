package user_login;

public class UserLoginController {
    private final UserLogin userLogin;

    /**
     * A Login Controller for the use case UserLogin to use.
     */
    public UserLoginController(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    /**
     * Takes the user's username and password and logs them in.
     * @param username The user's username.
     * @param password The user's password.
     */
    public void login(String username, String password) {
        userLogin.loginUser(username, password);
    }

}
