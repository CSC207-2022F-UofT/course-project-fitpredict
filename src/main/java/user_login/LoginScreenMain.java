package user_login;


public class LoginScreenMain {
    /**
     * Creates the User Login Screen.
     */
    public static void main(String[] args) {
        UserAccountList users = new UserAccountList();
        users.addNewUser(new User("selintasman1", "Hello1234", "Hello1234", 15.0, 1.64, "Female",
                "2002-08-14"));
        UserLogin userLogin = new UserLogin(users);
        UserLoginController controller = new UserLoginController(userLogin);
        //LoginInputBoundary loginInputBoundary = (username, password) -> null;
        //UserLoginController userLoginController = new UserLoginController(loginInputBoundary);
        UserLoginScreen screen = new UserLoginScreen(controller);
        screen.pack();
        screen.setVisible(true);

    }
}
