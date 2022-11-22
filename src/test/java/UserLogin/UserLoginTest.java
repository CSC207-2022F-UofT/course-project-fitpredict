package UserLogin;

import entities.User;
import org.junit.jupiter.api.Test;
import use_cases.UserAccountList;
import use_cases.UserLogin;

public class UserLoginTest {

    User user1 = new User("selin1", "Hello1234", "Hello1234",
            15.0, 1.64, "Female", "2002-08-14");
    UserAccountList users = new UserAccountList();

    @Test
    public void loginUserNoLogTest() {
        UserLogin userLogin = new UserLogin(users);
        UserLogin.LogInResult expected = UserLogin.LogInResult.NO_LOG;
        UserLogin.LogInResult actual = userLogin.loginUser(user1.getUsername(), user1.getPassword());
        assert (expected != actual);

    }
    @Test
    public void loginUserLogTest() {
        UserLogin userLogin = new UserLogin(users);
        UserLogin.LogInResult expected = UserLogin.LogInResult.LOG;
        UserLogin.LogInResult actual = userLogin.loginUser(user1.getUsername(), user1.getPassword());
        assert (expected == actual);
    }
}
