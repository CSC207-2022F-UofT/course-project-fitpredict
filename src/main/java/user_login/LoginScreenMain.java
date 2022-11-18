package user_login;


public class LoginScreenMain {
    /**
     * Creates the User Login Screen.
     */
    public static void main(String[] args) {
        UserLogin userLogin = new UserLogin();
        UserAccountList users = new UserAccountList();
        LoginInputBoundary loginInputBoundary = (username, password) -> null;

        UserLoginController userLoginController = new UserLoginController(loginInputBoundary);


        UserLoginScreen screen = new UserLoginScreen(userLoginController);
        screen.pack();
        screen.setVisible(true);

    }
}
