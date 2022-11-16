package user_creator;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Objects;


public class UserCreator{

    public UserCreator(UserAccountList existingUsers) {

    }

    public ArrayList<String> accountCreator(String username, String password, String repeatPassword, Float height, Float weight, String sex, String birthday){
        return accountIsCreated;
    }

    public ArrayList<String> checkUsernamePasswordValid(String username, String password, String repeatPassword){
        return new ArrayList<>(0);
    }

    public ArrayList<String> checkPersonalInfoValid(Float height, Float weight, String sex, String birthday){
        return new ArrayList<>(0);
    }

    public ArrayList<String> checkUsername(String username){
        return exists;
    }

    public boolean checkUsernameValid(String username){
        return numChar >= 5 && numLetters > 0 && numNumbers > 0;
    }

    public boolean checkPasswordValid(String password){
        return numChar >= 5 && numLetters > 0 && numNumbers > 0;
    }

    public boolean checkTwoPasswordsMatch(String password, String repeatPassword){
        return Objects.equals(password, repeatPassword);
    }

    public boolean checkHeight(Float height){
        return height > MINIMUM_VALUE;
    }

    public boolean checkWeight(Float weight){
        return weight > MINIMUM_VALUE;
    }

    public boolean checkBirthday(String birthday){
        return true;
    }

    public boolean checkSex(String sex){
        return true;
    }
}
