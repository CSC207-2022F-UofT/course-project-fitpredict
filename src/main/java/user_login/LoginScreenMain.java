package user_login;


public class LoginScreenMain {
    /**
     * Creates the User Login Screen.
     */
    public static void main(String[] args) {
        UserLogin userLogin = new UserLogin();
        LoginInputBoundary loginInputBoundary = new LoginInputBoundary() {
            @Override
            public UserLogin.LogInResult loginUser(String username, String password) {
                return null;
            }
        };
        UserLoginController userLoginController = new UserLoginController(loginInputBoundary);
        UserLoginScreen screen = new UserLoginScreen(userLoginController);
        screen.pack();
        screen.setVisible(true);

    }
}
