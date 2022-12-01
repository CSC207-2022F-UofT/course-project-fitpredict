package use_cases;


import entities.CurrentUser;
import use_cases.LoginInputBoundary;
import use_cases.UserAccountList;
import entities.User;

public class UserLogin implements LoginInputBoundary {

    /**
     * A list of users created.
     */
    private UserAccountList users;
    private CurrentUser currentUser;
    UserReadWriter userReadWriter = new UserReadWriter();

    public UserLogin(UserAccountList userAccountList) {
        this.users = userAccountList;
        try {
            //userReadWriter.saveToFile("accounts.ser", users);
            userReadWriter.readFromFile("accounts.ser");
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

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
        if (users.getUser(username) != null) {
            if (!user.checkPasswordMatches(password)) {
                System.out.println("The passwords don't match");
                return LogInResult.NO_LOG;
            }
            CurrentUser.getInstance().setUser(user); // This is the user that is currently logged in.
            return LogInResult.LOG;
        }
        else {
            return LogInResult.NO_LOG;
        }
    }

    public UserAccountList getUserAccountList(){
        return this.users;
    }
}