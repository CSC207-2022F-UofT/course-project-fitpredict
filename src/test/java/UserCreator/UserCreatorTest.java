package UserCreator;
import use_cases.UserAccountList;
import use_cases.UserCreator;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserCreatorTest {
    @Test
    public void UserCreatorCorrect(){
        UserAccountList userList = new UserAccountList();
        UserCreator uc = new UserCreator(userList);

        ArrayList<String> newUser =  uc.accountCreator("DinaL2003", "hello1", "hello1", 123.0, 123.0, "Female", "2003-08-20");

        ArrayList<String> accountIsCreated = new ArrayList<>(0);
        accountIsCreated.add("Account has been created!");

        // Assert that the return message is the 'account created' message
        assertEquals(newUser, accountIsCreated);
    }

    @Test
    public void UserCreatorExistingUsername(){
        UserAccountList userList = new UserAccountList();
        UserCreator uc = new UserCreator(userList);

        ArrayList<String> existingUser =  uc.accountCreator("DinaL2003", "hello1", "hello1", 123.0, 123.0, "Female", "2003-08-20");
        ArrayList<String> newUser = uc.accountCreator("DinaL2003", "goodbye1", "goodbye1", 123.0, 123.0, "Other", "199-05-15");

        ArrayList<String> usernameExists = new ArrayList<>(0);
        usernameExists.add("Username already exists");

        // Assert that the return message is the 'username already exists' message
        assertEquals(newUser, usernameExists);
    }

    @Test
    public void UserCreatorInvalidUsername(){
        UserAccountList userList = new UserAccountList();
        UserCreator uc = new UserCreator(userList);

        ArrayList<String> newUser = uc.accountCreator("D", "goodbye1", "goodbye1", 123.0, 123.0, "Other", "199-05-15");

        ArrayList<String> usernameInvalid = new ArrayList<>(0);
        usernameInvalid.add("Username is invalid");

        // Assert that the return message is the 'username is invalid' message
        assertEquals(newUser, usernameInvalid);
    }

    @Test
    public void UserCreatorPasswordInvalid(){
        UserAccountList userList = new UserAccountList();
        UserCreator uc = new UserCreator(userList);

        ArrayList<String> newUser =  uc.accountCreator("DinaL2003", "ok", "ok", 123.0, 123.0, "Female", "2003-08-20");

        ArrayList<String> passwordInvalid = new ArrayList<>(0);
        passwordInvalid.add("Password is invalid");

        // Assert that the return message is the 'password is invalid' message
        assertEquals(newUser, passwordInvalid);
    }

    @Test
    public void UserCreatorPasswordsDoNotMatch(){
        UserAccountList userList = new UserAccountList();
        UserCreator uc = new UserCreator(userList);

        ArrayList<String> newUser =  uc.accountCreator("DinaL2003", "Hello1", "Hello2", 123.0, 123.0, "Female", "2003-08-20");

        ArrayList<String> passwordMatch = new ArrayList<>(0);
        passwordMatch.add("Passwords do not match");

        // Assert that the return message is the 'passwords do not match' message
        assertEquals(newUser, passwordMatch);
    }

    @Test
    public void UserCreatorHeightInvalid(){
        UserAccountList userList = new UserAccountList();
        UserCreator uc = new UserCreator(userList);

        ArrayList<String> newUser =  uc.accountCreator("DinaL2003", "Hello1", "Hello1", 0.0, 123.0, "Female", "2003-08-20");

        ArrayList<String> heightInvalid = new ArrayList<>(0);
        heightInvalid.add("Height is invalid");

        // Assert that the return message is the 'height is invalid' message
        assertEquals(newUser, heightInvalid);
    }

    @Test
    public void UserCreatorWeightInvalid(){
        UserAccountList userList = new UserAccountList();
        UserCreator uc = new UserCreator(userList);

        ArrayList<String> newUser =  uc.accountCreator("DinaL2003", "Hello1", "Hello1", 123.0, 0.0, "Female", "2003-08-20");

        ArrayList<String> weightInvalid = new ArrayList<>(0);
        weightInvalid.add("Weight is invalid");

        // Assert that the return message is the 'weight is invalid' message
        assertEquals(newUser, weightInvalid);
    }

    @Test
    public void UserCreatorBirthdayInvalid(){
        UserAccountList userList = new UserAccountList();
        UserCreator uc = new UserCreator(userList);

        ArrayList<String> newUser =  uc.accountCreator("DinaL2003", "Hello1", "Hello1", 123.0, 123.0, "Other", "2003");

        ArrayList<String> birthdayInvalid = new ArrayList<>(0);
        birthdayInvalid.add("Birthday is invalid");

        // Assert that the return message is the 'birthday is invalid' message
        assertEquals(newUser, birthdayInvalid);
    }

    @Test
    public void UserCreatorSexInvalid(){
        UserAccountList userList = new UserAccountList();
        UserCreator uc = new UserCreator(userList);

        ArrayList<String> newUser =  uc.accountCreator("DinaL2003", "Hello1", "Hello1", 123.0, 123.0, "Nothing", "2003-08-20");

        ArrayList<String> sexInvalid = new ArrayList<>(0);
        sexInvalid.add("Sex is invalid");

        // Assert that the return message is the 'sex is invalid' message
        assertEquals(newUser, sexInvalid);
    }
}
