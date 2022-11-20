package user_creator;
import java.util.ArrayList;

public class UserCreationController {
    private final UserCreator userCreator;

    /**
     * A creation controller for the use case user-creation to use
     */
    public UserCreationController(UserCreator userCreator) {
        this.userCreator = userCreator;
    }

    /**
     * Takes the user input, creates an account, and returns an account creation message
     * @param username The user's username
     * @param password The user's password
     * @param repeatPassword The user's repeat password
     * @param height The user's height
     * @param weight THe user's weight
     * @param sex The user's sex
     * @param birthday The user's birthday
     * @return if all user input is valid
     */
    public ArrayList<String> accountCreator(String username, String password, String repeatPassword,
                                            Double height, Double weight, String sex, String birthday) {
        return userCreator.accountCreator(username, password, repeatPassword, height, weight, sex, birthday);
    }



}
