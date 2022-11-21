package use_cases;

import entities.User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserAccountList implements Serializable {

// This keeps track of who has created an account before and adds accounts to a list if they are new.

    private final Map<String, User> userAccountList = new HashMap<>();


     /**
     * Add a new User to the existing list of users
     */
     public void addNewUser(User newUser){
         userAccountList.put(newUser.getUsername(), newUser);

     }

     public User getUser(String username) {
         return userAccountList.get(username);
     }


}



