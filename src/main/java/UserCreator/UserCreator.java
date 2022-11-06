package UserCreator;
import java.util.ArrayList;
import java.time.LocalDateTime;


public class UserCreator{
    private UserAccountList existingUsers;

    //accountCreator
    public ArrayList<String> accountCreator(String username, String password, String repeatedpassword, Float weight, Float height, LocalDateTime birthday, String sex){
        User newUser = new User(username, password);

        ArrayList<String> exists = checkUsername(username);

        ArrayList<String> usernameInvalid = new ArrayList<>(0);
        usernameInvalid.add("Username is Invalid.");

        ArrayList<String> passwordInvalid = new ArrayList<>(0);
        passwordInvalid.add("Password is Invalid.");

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

        if (exists.size() == 0){
            if(checkUsernameValid(username)){
                 if(checkPasswordValid(password)){
                     if(checkPasswordsMatch(password, repeatedpassword)){
                         if(checkWeight(weight)){
                             if(checkHeight(height)){
                                 if(checkBirthday(birthday)){
                                     if(checkSex(sex)){
                                         this.existingUsers.AddNewUser(newUser);
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

    //checkUsername
    public ArrayList<String> checkUsername(String username){
        ArrayList<String> exists = new ArrayList<>(0);
        if (existingUsers.getUser(username) != null) { // this means the username is already listed in the system
            exists.add("Username already exists.");
        }
        return exists;
    }

    //checkUsernameValid
    public boolean checkUsernameValid(String username){
        int num_char = 0;
        int num_letters = 0;
        int num_numbers = 0;

        for (int i = 0; i < username.length(); i++){
            if(Character.isLetter(username.charAt(i))){
                num_letters++;
            }
            else if(Character.isDigit(username.charAt(i))){
                num_numbers++;
            }
            num_char++;
        }

        return num_char >= 5 && num_letters > 0 && num_numbers > 0;
    }

    //checkPasswordValid
    public boolean checkPasswordValid(String password){
        return true;
    }
    //repeatPassword
    public boolean repeatPassword(String repeatedpassword){
        // WHAT IS THIS DOING?? DO WE NEED IT??
        return true;
    }
    //checkPasswordsMatch
    public boolean checkPasswordsMatch(String password, String repeatedpassword){
        return password == repeatedpassword;
    }
    //checkHeight
    public boolean checkHeight(Float height){
        if(height > 0){
            return true;
        }
        return false;
    }
    //checkBirthday
    public boolean checkBirthday(LocalDateTime birthday){
        // HOW DO I DO THIS??
        return false;
    }
    //checkWeight
    public boolean checkWeight(Float weight){
        if(weight > 0){
            return true;
        }
        return false;
    }
    //checkSex
    public boolean checkSex(String sex){
        if(sex == "Female"){
            return true;
        }
        else if(sex == "Male"){
            return true;
        }
        else if(sex == "Other"){
            return true;
        }
        return false;
    }



}
