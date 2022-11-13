package user_login;


import java.io.IOException;

public class UserLogin {

    private UserAccountList existing_users;
    //UserReadWriter userReadWriter = new UserReadWriter();

    //public UserLogin (UserAccountList users) {
        //this.existing_users = users;
        //try {
            //userReadWriter.readFromFile("users.ser");
        //} catch (IOException | ClassNotFoundException error) {
            //System.out.println("Failed");
        //}
    //}

    public User loginUser(String username, String password) {
        User user = existing_users.getUser(username);
        if (!user.checkPasswordMatches(password)) {
            System.out.println("The passwords don't match.");
        }
        return user;
    }
}
