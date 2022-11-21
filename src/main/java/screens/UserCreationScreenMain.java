package screens;

import use_cases.UserAccountList;
import use_cases.UserCreator;
import controllers.UserCreationController;

public class UserCreationScreenMain {
    public static void main(String[] args) {
        UserAccountList users = new UserAccountList();
        UserCreator userCreator = new UserCreator(users);
        UserCreationController userCreationController = new UserCreationController(userCreator);
        UserCreationScreen screen = new UserCreationScreen(userCreationController);
        screen.pack();
        screen.setVisible(true);
    }
}
