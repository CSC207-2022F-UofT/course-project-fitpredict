package UserLogin;
import UserLogin.UserLogin;

public class UserLoginController {
    private final UserLogin userLogin;

    public UserLoginController(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public boolean login(String username, String password) {
        return userLogin.loginUser2(username, password);
    }

}
