package user_login;

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
    public void login(String username, String password) {
        UserLogin.LogInResult result = loginInputBoundary.loginUser(username, password);
        switch (result){
            case LOG:
                System.out.println("Logged in successfully");
            case NO_LOG:
                System.out.println("Failed to login");
        }
    }

}
