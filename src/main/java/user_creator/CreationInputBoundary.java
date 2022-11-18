package user_creator;

/**
 * The input boundary for the UserCreator use case
 */
public interface CreationInputBoundary {
    UserCreator accountCreator(String username, String password, String repeatPassword,
                               Double height, Double weight, String sex, String birthday);
}
