package user_login;

public class UserLoginController {
    private final UserLogin userLogin;

    public UserLoginController(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public User login(String username, String password) {
        return userLogin.loginUser(username, password);
    }

}
