package user_login;

/**
 * The input boundary for the UserLogin use case
 */
public interface LoginInputBoundary {
    UserLogin loginUser(String username, String password);
}
