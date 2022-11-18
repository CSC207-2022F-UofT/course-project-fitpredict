package user_creator;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Creates a valid user account
 */
public class UserCreator {
    private final UserAccountList existingUsers;
    UserReadWriter userReadWriter = new UserReadWriter();

    // File methods

    /**
     * Saves the existing users to a file
     *
     * @param existingUsers is the list of existing users
     */
    public UserCreator(UserAccountList existingUsers) {
        this.existingUsers = existingUsers;
        try {
            userReadWriter.saveToFile("RegisteredAccountsList.ser", existingUsers);
        } catch (IOException e) {
            System.out.println("The Account List could not be saved.");
        }
    }

    //accountCreator

    /**
     * Takes the user input, creates an account, and returns an account creation message
     *
     * @param username       The user's username
     * @param password       The user's password
     * @param repeatPassword The user's repeat password
     * @param height         The user's height
     * @param weight         THe user's weight
     * @param sex            The user's sex
     * @param birthday       The user's birthday
     * @return if all user input is valid
     */
    public ArrayList<String> accountCreator(String username, String password, String repeatPassword, Double height, Double weight, String sex, String birthday) {
        User newUser = new User(username, password, repeatPassword, height, weight, sex, birthday);

        ArrayList<String> exists = checkUsername(username);

        ArrayList<String> accountIsCreated = new ArrayList<>(0);
        accountIsCreated.add("Account has been created!");

        if (exists.size() == 0) {
            if (checkUsernamePasswordValid(username, password, repeatPassword).size() == 0) {
                if (checkPersonalInfoValid(height, weight, sex, birthday).size() == 0) {
                    this.existingUsers.addNewUser(newUser);
                    return accountIsCreated;
                }
                return checkPersonalInfoValid(height, weight, sex, birthday);
            }
            return checkUsernamePasswordValid(username, password, repeatPassword);
        }
        return exists;
    }

    //checkUsernamePasswordValid, checks to see if both the username and the given passwords a) match, and b) are valid

    /**
     * Returns a message depending on the validity of user input regarding username and passwords
     *
     * @param username       The user's username
     * @param password       The user's password
     * @param repeatPassword The user's repeated password
     * @return an empty message if information is valid, returns a non-empty message otherwise
     */
    public ArrayList<String> checkUsernamePasswordValid(String username, String password, String repeatPassword) {

        ArrayList<String> usernameInvalid = new ArrayList<>(0);
        usernameInvalid.add("Username is invalid");

        ArrayList<String> passwordInvalid = new ArrayList<>(0);
        passwordInvalid.add("Password is invalid");

        ArrayList<String> passwordMatch = new ArrayList<>(0);
        passwordMatch.add("Passwords do not match");

        if (!checkUsernameValid(username)) {
            return usernameInvalid;
        } else if (!checkPasswordValid(password)) {
            return passwordInvalid;
        } else if (!checkTwoPasswordsMatch(password, repeatPassword)) {
            return passwordMatch;
        }

        return new ArrayList<>(0); // it is empty, meaning no error message
    }

    //checkPersonalInfoValid, checks to see if all personal information is valid

    /**
     * Returns a message depending on the validity of user input regarding user's personal information
     *
     * @param height   The user's height
     * @param weight   The user's weight
     * @param sex      the user's sex
     * @param birthday The user's birthday
     * @return an empty message if information is valid, returns a non-empty message otherwise
     */
    public ArrayList<String> checkPersonalInfoValid(Double height, Double weight, String sex, String birthday) {

        ArrayList<String> heightInvalid = new ArrayList<>(0);
        heightInvalid.add("Height is invalid");

        ArrayList<String> weightInvalid = new ArrayList<>(0);
        weightInvalid.add("Weight is invalid");

        ArrayList<String> birthdayInvalid = new ArrayList<>(0);
        birthdayInvalid.add("Birthday is invalid");

        ArrayList<String> sexInvalid = new ArrayList<>(0);
        sexInvalid.add("Sex is invalid");

        if (!checkHeight(height)) {
            return heightInvalid;
        } else if (!checkWeight(weight)) {
            return weightInvalid;
        } else if (!checkBirthday(birthday)) {
            return birthdayInvalid;
        } else if (!checkSex(sex)) {
            return sexInvalid;
        }

        return new ArrayList<>(0); // it is empty, meaning no error message
    }

    //checkUsername, checks to see if it already exists in the system

    /**
     * Returns a message depending on if the user's username already exists in the list
     *
     * @param username The user's username
     * @return an empty message if username does not previously exist and returns a non-empty message otherwise
     */
    public ArrayList<String> checkUsername(String username) {
        ArrayList<String> exists = new ArrayList<>(0);
        if (existingUsers.getUser(username) != null) {
            exists.add("Username already exists");
        }
        return exists;
    }

    //checkUsernameValid, make sure it's longer than 5 characters and contains both letters and numbers

    /**
     * Returns true if the input username is valid
     *
     * @param username the user's username
     * @return if the input username is valid
     */
    public boolean checkUsernameValid(String username) {
        int numChar = 0;
        int numLetters = 0;
        int numNumbers = 0;

        for (int i = 0; i < username.length(); i++) {
            if (Character.isLetter(username.charAt(i))) {
                numLetters++;
                numChar++;
            } else if (Character.isDigit(username.charAt(i))) {
                numNumbers++;
                numChar++;
            }
        }
        return numChar >= 5 && numLetters > 0 && numNumbers > 0;
    }

    //checkPasswordValid, make sure it is longer than 5 characters and contains both letters and numbers

    /**
     * Returns true is the input password is valid
     *
     * @param password The user's password
     * @return if the input password is valid
     */
    public boolean checkPasswordValid(String password) {
        int numChar = 0;
        int numLetters = 0;
        int numNumbers = 0;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isLetter(password.charAt(i))) {
                numLetters++;
                numChar++;
            } else if (Character.isDigit(password.charAt(i))) {
                numNumbers++;
                numChar++;
            }
            numChar++;
        }

        return numChar >= 5 && numLetters > 0 && numNumbers > 0;
    }

    //checkTwoPasswordsMatch

    /**
     * Returns true if the input passwords are the same
     *
     * @param password The user's password
     * @param repeatPassword The user's repeated password
     * @return if the input passwords match
     */
    public boolean checkTwoPasswordsMatch(String password, String repeatPassword) {
        return Objects.equals(password, repeatPassword);
    }

    static final Integer MINIMUM_VALUE = 0; // to avoid hardcoding and make it easier to change

    //checkHeight, height must be greater than 0

    /**
     * Returns true if the input height is valid
     *
     * @param height The user's height
     * @return if the input height is valid
     */
    public boolean checkHeight(Double height) {
        return height > MINIMUM_VALUE;
    }

    //checkWeight, weight must be greater than 0

    /**
     * Returns true if the input weight is valid
     *
     * @param weight The user's weight
     * @return if the input weight is valid
     */
    public boolean checkWeight(Double weight) {
        return weight > MINIMUM_VALUE;
    }

    //checkBirthday

    /**
     * Returns true if the input birthday is valid
     *
     * @param birthday The user's birthday
     * @return if the input birthday is valid
     */
    public boolean checkBirthday(String birthday) {
        try {
            LocalDate date = LocalDate.parse(birthday);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    //checkSex, must be either Female, Male, or Other

    /**
     * Returns true if the input sex is valid
     *
     * @param sex The user's sex
     * @return if the input sex is valid
     */
    public boolean checkSex(String sex) {
        if (Objects.equals(sex, "Female")) {
            return true;
        } else if (Objects.equals(sex, "Male")) {
            return true;
        } else return Objects.equals(sex, "Other");
    }
}
