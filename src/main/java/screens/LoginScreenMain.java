package screens;

import use_cases.UserAccountList;
import use_cases.UserLogin;
import controllers.UserLoginController;

public class LoginScreenMain {
    /**
     * Creates the User Login Screen.
     */
    public static void main(String[] args) {
        UserAccountList users = new UserAccountList();
        users.addNewUser(new entities.User("selintasman1", "Hello1234", "Hello1234", 15.0, 1.64, "Female",
                "2002-08-14"));
        UserLogin userLogin = new UserLogin(users);
        UserLoginController controller = new UserLoginController(userLogin);
        UserLoginScreen screen = new UserLoginScreen(controller);
        screen.pack();
        screen.setVisible(true);
    }
}
