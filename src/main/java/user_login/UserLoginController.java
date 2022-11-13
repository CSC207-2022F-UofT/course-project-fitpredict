package user_login;

public class UserLoginController {
    private final UserLogin userLogin;

    public UserLoginController(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public void login(String username, String password) {
        userLogin.loginUser(username, password);
    }

}
