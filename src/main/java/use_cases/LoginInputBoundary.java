package use_cases;

/**
 * The input boundary for the UserLogin use case
 */
public interface LoginInputBoundary {
    UserLogin.LogInResult loginUser(String username, String password);

    UserAccountList getUserAccountList();
}
