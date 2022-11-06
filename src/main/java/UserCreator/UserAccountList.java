package UserCreator;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// keeps track of who has created an account before and adds accounts to a list if they are new

public class UserAccountList implements Serializable{
    private final Map<String, User> useraccountlist = new HashMap<>();


    /**
     * Add a new User to the existing list of users
     */
    public void AddNewUser(User NewUser){
        useraccountlist.put(NewUser.getUsername(), NewUser); // we need to create a User entity and getUsername method.


    }

}
