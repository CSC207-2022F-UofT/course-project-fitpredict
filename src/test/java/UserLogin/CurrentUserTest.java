package UserLogin;
import entities.CurrentUser;
import entities.User;
import org.junit.jupiter.api.Test;


public class CurrentUserTest {
    CurrentUser user1 = new CurrentUser("Selin1", "A12345", "A12345", 15.0, 1.55,
            "Female", "2002-07-14");

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
        User expected = user1;
        user1.setUser(expected);
        assert (user1.getUser().equals(expected));
    }

}
