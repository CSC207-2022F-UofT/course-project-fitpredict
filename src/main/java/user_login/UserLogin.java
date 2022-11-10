package user_login;


public class UserLogin {

    private UserAccountList users;
    // UserReadWriter userReadWriter = new UserReadwriter(); do we need this?

    public User loginUser(String username, String password) {
        User user = users.getUser(username);
        if (!user.checkPasswordMatches(password)) {
            System.out.println("The passwords don't match.");
        }
        return user;
    }

    // Or do this:
    //public boolean loginUser2(String username, String password) {
        //User user = users.getUser(username);
        //return user.checkUsernameMatches(username) && user.checkPasswordMatches(password);
    //}

}
