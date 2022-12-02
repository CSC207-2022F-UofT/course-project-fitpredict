import controllers.UserLoginController;
import entities.User;
import screens.UserLoginScreen;
import use_cases.UserAccountList;
import use_cases.UserLogin;

public class Main {
    public static void main(String[] args) {
        UserAccountList users = new UserAccountList();
        //users.addNewUser(new User("user1", "Hello123", "Hello123", 65.0, 1.8, "Male", "2003-11-11"));
        UserLogin userLogin = new UserLogin(users);
        UserLoginController userLoginController = new UserLoginController(userLogin);
        UserLoginScreen userLoginScreen = new UserLoginScreen(userLoginController);
        userLoginScreen.pack();
        userLoginScreen.setVisible(true);
    }
}
