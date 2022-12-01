package UserLogin;
import entities.CurrentUser;
import entities.User;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CurrentUserTest {
    User user1; // The user that is to be logged in

    @Before
    public void setUp() {
        user1 = new User("Selin1", "A12345", "A12345", 15.0, 1.55,
                "Female", "2002-07-14");
        CurrentUser.getInstance().setUser(user1); // LOG IN THE USER!
    }

    @After
    public void tearDown() {}

    @Test
    public void getUserTest() {
        assertEquals(user1, CurrentUser.getInstance().getUser());
    }

    @Test
    public void getUsernameTest() {
         assertEquals ("Selin1", CurrentUser.getInstance().getUser().getUsername());
    }

    @Test
    public void setUsernameTest() {
        String expected = "Sonat1";
        CurrentUser.getInstance().getUser().setUsername(expected);
        assertEquals(expected, CurrentUser.getInstance().getUser().getUsername());
    }

    @Test
    public void setUserTest() {
        User user2 = new User("Selin2", "A12343", "A12343", 15.2, 1.52,
                "Female", "2002-07-12");
        CurrentUser.getInstance().setUser(user2);
        assertEquals(user2, CurrentUser.getInstance().getUser());
    }

}
