package login;
import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.UserAccountList;

public class UserAccountListTest {
    UserAccountList users = new UserAccountList();
    User user1 = new User("selin1", "Hello1234", "Hello1234",
            15.0, 1.64, "Female", "2002-08-14");
    User user2 = new User("sarp1", "Bonjour1234", "Bonjour1234",
            16.0, 1.80, "Male", "2003-10-21");


    @Test
    public void testUserAccountListAdd() {
        users.addNewUser(user1);
        users.addNewUser(user2);
        Assertions.assertEquals(users.getUser("selin1"), user1);
        Assertions.assertEquals(users.getUser("sarp1"), user2);
    }

    @Test
    public void testUserAccountListGetUser() {
        UserAccountList list = new UserAccountList();
        list.addNewUser(user1);
        User user = list.getUser("selin1");
        Assertions.assertEquals(user, user1);
    }
}

