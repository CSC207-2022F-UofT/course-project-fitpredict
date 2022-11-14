package user_login;


import java.io.IOException;

public class UserLogin {

    private UserAccountList users;
    private User currentUser;
    //UserReadWriter userReadWriter = new UserReadWriter();

    public User loginUser(String username, String password) {
        User user = users.getUser(username);
        if (!user.checkPasswordMatches(password)) {
            System.out.println("The passwords don't match.");
        }
        currentUser = user;
        return user;
    }

    public User getCurrentUser() {
        return this.currentUser;
    }



}
