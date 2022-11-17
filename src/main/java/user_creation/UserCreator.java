package user_creation;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Creates a valid user account
 */
public class UserCreator{
    private final UserAccountList existingUsers;
    UserReadWriter userReadWriter = new UserReadWriter();

    /**
     * Saves the existing users to a file
     * @param existingUsers is the list of existing users
     */
    public UserCreator(UserAccountList existingUsers) {

    }

    /**
     * Takes the user input, creates an account, and returns an account creation message
     * @param username The user's username
     * @param password The user's password
     * @param repeatPassword The user's repeat password
     * @param height The user's height
     * @param weight THe user's weight
     * @param sex The user's sex
     * @param birthday The user's birthday
     * @return if all user input is valid
     */
    public ArrayList<String> accountCreator(String username, String password, String repeatPassword, Double height, Double weight, String sex, String birthday){
        return accountIsCreated;
    }

    /**
     * Returns a message depending on the validity of user input regarding username and passwords
     * @param username The user's username
     * @param password The user's password
     * @param repeatPassword The user's repeated password
     * @return an empty message if information is valid, returns a non-empty message otherwise
     */
    public ArrayList<String> checkUsernamePasswordValid(String username, String password, String repeatPassword){
        return new ArrayList<>(0);
    }

    /**
     * Returns a message depending on the validity of user input regarding user's personal information
     * @param height The user's height
     * @param weight The user's weight
     * @param sex the user's sex
     * @param birthday The user's birthday
     * @return an empty message if information is valid, returns a non-empty message otherwise
     */
    public ArrayList<String> checkPersonalInfoValid(Double height, Double weight, String sex, String birthday){
        return new ArrayList<>(0);
    }

    /**
     * Returns a message depending on if the user's username already exists in the list
     * @param username The user's username
     * @return an empty message if username does not previously exist and returns a non-empty message otherwise
     */
    public ArrayList<String> checkUsername(String username){
        return exists;
    }

    /**
     * Returns true if the input username is valid
     * @param username the user's username
     * @return if the input username is valid
     */
    public boolean checkUsernameValid(String username){
        return numChar >= 5 && numLetters > 0 && numNumbers > 0;
    }

    /**
     * Returns true is the input password is valid
     * @param password The user's password
     * @return if the input password is valid
     */
    public boolean checkPasswordValid(String password){
        return numChar >= 5 && numLetters > 0 && numNumbers > 0;
    }

    /**
     * Returns true if the input passwords are the same
     * @param password The user's password
     * @param repeatPassword The user's repeated password
     * @return if the input passwords match
     */
    public boolean checkTwoPasswordsMatch(String password, String repeatPassword){
        return Objects.equals(password, repeatPassword);
    }


    static final Integer MINIMUM_VALUE = 0;

    /**
     * Returns true if the input height is valid
     * @param height The user's height
     * @return if the input height is valid
     */
    public boolean checkHeight(Double height){
        return height > MINIMUM_VALUE;
    }

    /**
     * Returns true if the input weight is valid
     * @param weight The user's weight
     * @return if the input weight is valid
     */
    public boolean checkWeight(Double weight){
        return weight > MINIMUM_VALUE;
    }

    /**
     * Returns true if the input birthday is valid
     * @param birthday The user's birthday
     * @return if the input birthday is valid
     */
    public boolean checkBirthday(String birthday){
        return true;
    }


    /**
     * Returns true if the input sex is valid
     * @param sex The user's sex
     * @return if the input sex is valid
     */
    public boolean checkSex(String sex){
        return true;
    }
}
