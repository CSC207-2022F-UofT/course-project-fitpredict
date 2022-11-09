package UserLogin;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserAccountList implements Serializable {

// This keeps track of who has created an account before and adds accounts to a list if they are new

    private final Map<String, User> userAccountList = new HashMap<>();


     /**
     * Add a new User to the existing list of users
     */
     public void AddNewUser(User NewUser){
         userAccountList.put(NewUser.getUsername(), NewUser);

     }

     public User getUser(String username) {
         return userAccountList.get(username);
     }


}



