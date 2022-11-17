package user_login;

public class UserLogin {

    /**
     * A list of users created.
     */
    private UserAccountList users;
    private User currentUser;
    //UserReadWriter userReadWriter = new UserReadWriter();

    /**
     * Takes the user's username and password and logs them in if the passwords match.
     * @param username The user's username.
     * @param password The user's password.
     * @return whether the inputted password matches the password linked to that username. .
     */
    public User loginUser(String username, String password) {
        User user = users.getUser(username);
        if (!user.checkPasswordMatches(password)) {
            System.out.println("The passwords don't match.");
        }
        currentUser = user;
        return user;
    }

    /**
     * Returns the current user that is logged in.
     * @return the current user.
     */
    public User getCurrentUser() {
        return this.currentUser;
    }
}
