package UserLogin;

import java.io.IOException;

public class UserLogin {

    private UserAccountList users;
    // UserReadWriter userReadWriter = new UserReadwriter();

    public User loginUser(String username, String password) {
        User user = users.getUser(username);
        try {
            (user.checkPasswordMatches(password) && user.checkUsernameMatches(username));
        } catch (IOException e) {
            System.out.println("The passwords don't match.");

        }
        return user;
    }

    // Or do this:
    public boolean loginUser2(String username, String password) {
        User user = users.getUser(username);
        return user.checkUsernameMatches(username) && user.checkPasswordMatches(password);
    }

}
