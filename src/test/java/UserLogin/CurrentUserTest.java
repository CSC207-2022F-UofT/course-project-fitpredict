package UserLogin;
import entities.CurrentUser;
import entities.User;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;


public class CurrentUserTest {
    CurrentUser user1;

    @Before
    public void setUp() {
        user1 = new CurrentUser("Selin1", "A12345", "A12345", 15.0, 1.55,
                "Female", "2002-07-14");
    }

    @After
    public void tearDown() {}

    @Test
    public void getUserTest() {
        assert (user1.getUser().equals(user1));
    }

    @Test
    public void getUsernameTest() {
         assert (user1.getUsername().equals("Selin1"));
    }

    @Test
    public void setUsernameTest() {
        String expected = "Sonat1";
        user1.setUsername(expected);
        assert (user1.getUsername().equals(expected));
    }

    @Test
    public void setUserTest() {
        user1.setUser(user1);
        assert (user1.getUser().equals(user1));
    }

}
