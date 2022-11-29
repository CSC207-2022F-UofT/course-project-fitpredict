import controllers.UserCreationController;
import controllers.UserLoginController;
import screens.DashboardScreen;
import screens.UserCreationScreen;
import screens.UserLoginScreen;
import use_cases.UserAccountList;
import use_cases.UserCreator;
import use_cases.UserLogin;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Build the main program window
//        JFrame application = new JFrame("Dashboard Display");
//        CardLayout cardLayout = new CardLayout();
//        JPanel screens = new JPanel(cardLayout);
//        application.add(screens);
//        DashboardScreen dashboardScreen = new DashboardScreen();
//        screens.add(dashboardScreen);
//        cardLayout.show(screens, "dashboard");
//
//        application.pack();
//        application.setVisible(true);
        UserAccountList users = new UserAccountList();
        UserLogin userLogin = new UserLogin(users);
        UserLoginController userLoginController = new UserLoginController(userLogin);
        UserLoginScreen userLoginScreen = new UserLoginScreen(userLoginController);
        userLoginScreen.pack();
        userLoginScreen.setVisible(true);
    }
}
