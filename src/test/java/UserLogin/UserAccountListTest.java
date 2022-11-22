package UserLogin;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import entities.User;
import use_cases.UserAccountList;

import static org.junit.Assert.assertEquals;


class UserAccountListTest {
    UserAccountList users = new UserAccountList();
    User user1;
    User user2;

    @Before
    public void setUp() {
        UserAccountList users = new UserAccountList();
        user1 = new User("selin1", "Hello1234", "Hello1234",
                15.0, 1.64, "Female", "2002-08-14");
        user2 = new User("sarp1", "Bonjour1234", "Bonjour1234",
                16.0, 1.80, "Male", "2003-10-21");
    }

    @After
    public void tearDown(){}

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