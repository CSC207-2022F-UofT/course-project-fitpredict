package user_login;


public class LoginScreenMain {
    public static void main(String[] args) {
        UserLogin userLogin = new UserLogin();
        UserLoginController userLoginController = new UserLoginController(userLogin);
        UserLoginScreen screen = new UserLoginScreen(userLoginController);
        screen.pack();
        screen.setVisible(true);

    }
}
