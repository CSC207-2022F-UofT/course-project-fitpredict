package user_creator;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// This keeps track of who has created an account before and adds accounts to a list if they are new

/**
 * Creates a map of users
 */
public class UserAccountList implements Serializable {
    private final Map<String, User> useraccountlist = new HashMap<>();


    /**
     * Adds a new User to the existing list of users
     * @param NewUser is the user to add to the list
     */
    public void addNewUser(User NewUser){
        useraccountlist.put(NewUser.getUsername(), NewUser); // we need to create a User entity and getUsername method.

    }

    /**
     * Returns the user's username
     * @param username is the username of the user
     * @return if the username exists in the exisiting list of users
     */
    public User getUser(String username) {
        return useraccountlist.get(username);
    }


}

