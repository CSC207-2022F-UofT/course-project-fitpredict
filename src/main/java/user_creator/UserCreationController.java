package user_creator;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserCreationController {
    private final UserCreator userCreator;

    public UserCreationController(UserCreator userCreator) {
        this.userCreator = userCreator;
    }

    public ArrayList<String> accountCreator(String username, String password, String repeatPassword,
                                            Float height, Float weight, String sex, String birthday) {
        return userCreator.accountCreator(username, password, repeatPassword, height, weight, sex, birthday);
    }



}
