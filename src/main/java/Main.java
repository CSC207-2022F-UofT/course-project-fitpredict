import controllers.UserLoginController;
import screens.UserLoginScreen;
import use_cases.UserAccountList;
import use_cases.UserLogin;

public class Main {
    public static void main(String[] args) {
        UserAccountList users = new UserAccountList();
        UserLogin userLogin = new UserLogin(users);
        UserLoginController userLoginController = new UserLoginController(userLogin);
        UserLoginScreen userLoginScreen = new UserLoginScreen(userLoginController);
        userLoginScreen.pack();
        userLoginScreen.setVisible(true);
    }
}
