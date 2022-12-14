package entities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

// This is our CurrentUser entity.
public class CurrentUser extends User {

    private static CurrentUser currentUser = null;
    private User user;


    /**
     * A user with account information.
     *
     * @param username       The user's username
     * @param password       The user's password
     * @param repeatPassword The user's repeated password
     * @param weight         The user's weight
     * @param height         The user's height
     * @param sex            The user's sex
     * @param birthday       The user's birthday
     */
    public CurrentUser(String username, String password, String repeatPassword, Double weight, Double height,
                       String sex, String birthday) {
        super(username, password, repeatPassword, height,weight, sex, birthday);
    }

    public CurrentUser() {

    }


    public static CurrentUser getInstance(){
        if (currentUser == null) {
            currentUser = new CurrentUser();
        }
        return currentUser;
    }

    public void setUser(User newUser) {
        this.user = newUser;
    }

    /**
     * Returns the current user that is logged in.
     * @return the current user.
     */
    public User getUser() {
        return user;
    }

    /**
     * Returns the current user that is logged in's username
     * @return the username of the user
     */
    public String getUsername() { return getUser().getUsername(); }
    /**
     * Returns the number of milliseconds since Epoch at the current date at 12:00 am.
     * This is necessary to use the current date since other constructors are deprecated.
     * @return number of milliseconds from Epoch
     */
    public static long currentDateEpoch() {
        LocalDate startLocalDate = LocalDate.now();
        Date startDate = Date.from(startLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return startDate.getTime();
    }

}
