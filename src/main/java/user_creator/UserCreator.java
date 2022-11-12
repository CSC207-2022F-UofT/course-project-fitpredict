package user_creator;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Objects;


public class UserCreator{
    private final UserAccountList existingUsers;
    UserReadWriter userReadWriter = new UserReadWriter();


    // File methods.
    public UserCreator(UserAccountList existingUsers) {
        this.existingUsers = existingUsers;
        try {
            userReadWriter.saveToFile("RegisteredAccountsList.ser", existingUsers);
        } catch (IOException error) {
            System.out.println("The Account List could not be saved.");
        }
    }

    //accountCreator
    public ArrayList<String> accountCreator(String username, String password, String repeatPassword, Float height, Float weight, String sex, LocalDateTime birthday){
        User newUser = new User(username, password, repeatPassword, height, weight, sex, birthday);

        ArrayList<String> exists = checkUsername(username);

        ArrayList<String> accountIsCreated = new ArrayList<>(0);
        accountIsCreated.add("Account has been created!");

        if (exists.size() == 0){
            if (checkUsernamePasswordValid(username, password, repeatPassword).size() == 0){
                if (checkPersonalInfoValid(height, weight, sex, birthday).size() == 0){
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

    public ArrayList<String> checkUsernamePasswordValid(String username, String password, String repeatPassword){

        ArrayList<String> usernameInvalid = new ArrayList<>(0);
        usernameInvalid.add("Username is invalid.");

        ArrayList<String> passwordInvalid = new ArrayList<>(0);
        passwordInvalid.add("Password is invalid.");

        ArrayList<String> passwordMatch = new ArrayList<>(0);
        passwordMatch.add("Passwords do not match.");

        if (!checkUsernameValid(username)){
            return usernameInvalid;
        }

        else if (!checkPasswordValid(password)){
            return passwordInvalid;
        }

        else if (!checkTwoPasswordsMatch(password, repeatPassword)) {
            return passwordMatch;
        }

        return new ArrayList<>(0); // it is empty, meaning no error message
    }

    //checkPersonalInfoValid, checks to see if all personal information is valid
    public ArrayList<String> checkPersonalInfoValid(Float height, Float weight, String sex, LocalDateTime birthday){

        ArrayList<String> heightInvalid = new ArrayList<>(0);
        heightInvalid.add("Height is invalid.");

        ArrayList<String> weightInvalid = new ArrayList<>(0);
        weightInvalid.add("Weight is invalid.");


        ArrayList<String> birthdayInvalid = new ArrayList<>(0);
        birthdayInvalid.add("Birthday is invalid.");

        ArrayList<String> sexInvalid = new ArrayList<>(0);
        sexInvalid.add("Sex is invalid.");

        if (!checkHeight(height)){
            return heightInvalid;
        }

        else if (!checkWeight(weight)){
            return weightInvalid;
        }

        else if (!checkBirthday(birthday)){
            return birthdayInvalid;
        }

        else if (!checkSex(sex)){
            return sexInvalid;
        }

        return new ArrayList<>(0); // it is empty, meaning no error message
    }

    //checkUsername, checks to see if it already exists in the system
    public ArrayList<String> checkUsername(String username){
        ArrayList<String> exists = new ArrayList<>(0);
        if (existingUsers.getUser(username) != null) {
            exists.add("Username already exists.");
        }
        return exists;
    }

    //checkUsernameValid, make sure it's longer than 5 characters and contains both letters and numbers
    public boolean checkUsernameValid(String username){
        int numChar = 0;
        int numLetters = 0;
        int numNumbers = 0;

        for (int i = 0; i < username.length(); i++){
            if(Character.isLetter(username.charAt(i))){
                numLetters++;
                numChar++;
            }
            else if(Character.isDigit(username.charAt(i))){
                numNumbers++;
                numChar++;
            }
            numChar++;
        }
        return numChar >= 5 && numLetters > 0 && numNumbers > 0;
    }

    //checkPasswordValid, make sure it's longer than 5 characters and contains both letters and numbers
    public boolean checkPasswordValid(String password){
        int numChar = 0;
        int numLetters = 0;
        int numNumbers = 0;

        for (int i = 0; i < password.length(); i++){
            if(Character.isLetter(password.charAt(i))){
                numLetters++;
                numChar++;
            }
            else if(Character.isDigit(password.charAt(i))){
                numNumbers++;
                numChar++;
            }
            numChar++;
        }

        return numChar >= 5 && numLetters > 0 && numNumbers > 0;
    }

    //repeatPassword
    public boolean repeatPassword(String repeatPassword){
        // WHAT IS THIS DOING?? DO WE NEED IT??
        return true;
    }

    //checkTwoPasswordsMatch
    public boolean checkTwoPasswordsMatch(String password, String repeatPassword){
        return Objects.equals(password, repeatPassword);
    }

    //checkHeight, height must be greater than 0
    public boolean checkHeight(Float height){
        return height > 0;
    }

    //checkBirthday
    public boolean checkBirthday(LocalDateTime birthday){
        // HOW DO I DO THIS??
        return false;
    }

    //checkWeight, weight must be greater than 0
    public boolean checkWeight(Float weight){
        return weight > 0;
    }

    //checkSex, must be either Female, Male, or Other
    public boolean checkSex(String sex){
        if(Objects.equals(sex, "Female")){
            return true;
        }
        else if(Objects.equals(sex, "Male")){
            return true;
        }
        else return Objects.equals(sex, "Other");
    }
}
