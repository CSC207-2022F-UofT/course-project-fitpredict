package user_login;

import java.io.Serializable;



/**
 * Creates a map of users
 */
public class UserAccountList implements Serializable {

    /**
     * Adds a new User to the existing list of users
     * @param NewUser is the user to add to the list
     */
    public void addNewUser(User NewUser){
    }

    /**
     * Returns the user's username
     * @param username is the username of the user
     * @return if the username exists in the existing list of users
     */
    public User getUser(String username){
        return UserAccountList.get(username);

    }

}
