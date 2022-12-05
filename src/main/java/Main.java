import controllers.UserLoginController;
import screens.UserLoginScreen;
import use_cases.UserAccountList;
import use_cases.UserLogin;
import use_cases.UserReadWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserReadWriter urw = new UserReadWriter();
        UserAccountList users;
        if (urw.isEmpty("accounts.ser")) {
            users = new UserAccountList();
        }
        else {
            users = urw.readFromFile("accounts.ser");
        }
        //users.addNewUser(new User("user1", "Hello123", "Hello123", 65.0, 1.8, "Male", "2003-11-11"));
        UserLogin userLogin = new UserLogin(users);
        UserLoginController userLoginController = new UserLoginController(userLogin);
        UserLoginScreen userLoginScreen = new UserLoginScreen(userLoginController);
        userLoginScreen.pack();
        userLoginScreen.setVisible(true);
    }
}
