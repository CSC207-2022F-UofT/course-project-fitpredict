package use_cases;

import java.util.ArrayList;

/**
 * The input boundary for the UserCreator use case
 */
public interface CreationInputBoundary {
    ArrayList<String> accountCreator(String username, String password, String repeatPassword,
                                     Double height, Double weight, String sex, String birthday);

    UserAccountList getExistingUsers();
}
