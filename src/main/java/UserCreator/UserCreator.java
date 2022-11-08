package UserCreator;
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
    public ArrayList<String> accountCreator(String username, String password, String repeatPassword, Float weight, Float height, LocalDateTime birthday, String sex){
        User newUser = new User(username, password, repeatPassword, weight, height, sex, birthday);

        ArrayList<String> exists = checkUsername(username);

        ArrayList<String> usernameInvalid = new ArrayList<>(0);
        usernameInvalid.add("Username is invalid.");

        ArrayList<String> passwordInvalid = new ArrayList<>(0);
        passwordInvalid.add("Password is invalid.");

        ArrayList<String> passwordMatch = new ArrayList<>(0);
        passwordMatch.add("Passwords do not match.");

        ArrayList<String> weightInvalid = new ArrayList<>(0);
        weightInvalid.add("Weight is invalid.");

        ArrayList<String> heightInvalid = new ArrayList<>(0);
        heightInvalid.add("Height is invalid.");

        ArrayList<String> birthdayInvalid = new ArrayList<>(0);
        birthdayInvalid.add("Birthday is invalid.");

        ArrayList<String> sexInvalid = new ArrayList<>(0);
        sexInvalid.add("Sex is invalid.");

        ArrayList<String> accountIsCreated = new ArrayList<>(0);
        accountIsCreated.add("Account has been created!");

        if (exists.size() == 0){
            if(checkUsernameValid(username)){
                 if(checkPasswordValid(password)){
                     if(checkPasswordsMatch(password, repeatPassword)){
                         if(checkWeight(weight)){
                             if(checkHeight(height)){
                                 if(checkBirthday(birthday)){
                                     if(checkSex(sex)){
                                         this.existingUsers.AddNewUser(newUser);
                                         return accountIsCreated;
                                     }
                                     return sexInvalid;
                                 }
                                 return birthdayInvalid;
                             }
                             return heightInvalid;
                         }
                         return weightInvalid;
                     }
                     return passwordMatch;
                 }
                 return passwordInvalid;
            }
            return usernameInvalid;
        }
        return exists;
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
        int num_char = 0;
        int num_letters = 0;
        int num_numbers = 0;

        for (int i = 0; i < username.length(); i++){
            if(Character.isLetter(username.charAt(i))){
                num_letters++;
                num_char++;
            }
            else if(Character.isDigit(username.charAt(i))){
                num_numbers++;
                num_char++;
            }
            num_char++;
        }
        return num_char >= 5 && num_letters > 0 && num_numbers > 0;
    }

    //checkPasswordValid, make sure it's longer than 5 characters and contains both letters and numbers
    public boolean checkPasswordValid(String password){
        int num_char = 0;
        int num_letters = 0;
        int num_numbers = 0;

        for (int i = 0; i < password.length(); i++){
            if(Character.isLetter(password.charAt(i))){
                num_letters++;
                num_char++;
            }
            else if(Character.isDigit(password.charAt(i))){
                num_numbers++;
                num_char++;
            }
            num_char++;
        }

        return num_char >= 5 && num_letters > 0 && num_numbers > 0;
    }

    //repeatPassword
    public boolean repeatPassword(String repeatPassword){
        // WHAT IS THIS DOING?? DO WE NEED IT??
        return true;
    }

    //checkPasswordsMatch
    public boolean checkPasswordsMatch(String password, String repeatPassword){
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
