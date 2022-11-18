package user_login;


public class UserLogin {

    /**
     * A list of users created.
     */
    private UserAccountList users;
    private CurrentUser currentUser;
    UserReadWriter userReadWriter = new UserReadWriter();

    public enum LogInResult{
        LOG, NO_LOG
    }
    /**
     * Takes the user's username and password and logs them in if the passwords match.
     * @param username The user's username.
     * @param password The user's password.
     * @return whether the inputted password matches the password linked to that username. .
     */
    public LogInResult loginUser(String username, String password) {
        User user = users.getUser(username);
        if (!user.checkPasswordMatches(password)) {
            return LogInResult.NO_LOG;
        }
        currentUser.setUser(user);
        return LogInResult.LOG; // This is the user that is currently logged in.
    }
}