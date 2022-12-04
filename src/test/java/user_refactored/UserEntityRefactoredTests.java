package user_refactored;
import entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserEntityRefactoredTests {
    @Test
    public void userGetUsername(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        String userUsername = user.getUsername();

        assertEquals(userUsername, "dinalojpur1");
    }


    @Test
    public void userSetUsername(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        String newUsername = "SelinTasman1";

        user.setUsername(newUsername);
        String updatedUsername = user.getUsername();

        assertEquals(updatedUsername, "SelinTasman1");
    }

    @Test
    public void userGetWeight(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        Double takenWeight = user.getWeight();


        assertEquals(takenWeight, 123.0);
    }

    @Test
    public void userSetWeight(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        Double newWeight = 500.0;
        user.setWeight(newWeight);
        Double updatedWeight = user.getWeight();

        assertEquals(updatedWeight, 500.0);
    }

    @Test
    public void userGetHeight(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        Double takenHeight = user.getHeight();

        assertEquals(takenHeight, 321.0);
    }

    @Test
    public void userSetHeight(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        Double newHeight = 750.0;

        user.setHeight(newHeight);

        Double updatedHeight = user.getHeight();

        assertEquals(updatedHeight, 750.0);
    }

    @Test
    public void userGetSex(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        String takenSex = user.getSex();

        assertEquals(takenSex, "Female");
    }

    @Test
    public void userSetSex(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        String newSex = "Other";

        user.setSex(newSex);

        String updatedSex = user.getSex();

        assertEquals(updatedSex, "Other");
    }

    @Test
    public void userGetBirthday(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        String takenBirthday = user.getBirthday();

        assertEquals(takenBirthday, "2003-08-20");
    }

    @Test
    public void userGetPassword(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        String takenPassword = user.getPassword();

        assertEquals(takenPassword, "Hello1");
    }

    @Test
    public void userSetPassword(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        String newPassword = "leave123";
        user.setPassword(newPassword);

        String updatedPassword = user.getPassword();

        assertEquals(updatedPassword, "leave123");
    }

    @Test
    public void userGetRepeatedPassword(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        String takenPassword = user.getRepeatPassword();

        assertEquals(takenPassword, "Hello1");
    }

    @Test
    public void userSetRepeatedPassword(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        String newRepeatedPassword = "BBandLjuba1";

        user.setRepeatPassword(newRepeatedPassword);

        String updatedRepeatedPassword = user.getRepeatPassword();

        assertEquals(updatedRepeatedPassword, "BBandLjuba1");
    }
}
