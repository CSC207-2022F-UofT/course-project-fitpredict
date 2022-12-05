package user_creator;
import entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserEntityTest {
    @Test
    public void testUserGetUsername(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        String userUsername = user.getUsername();

        assertEquals(userUsername, "dinalojpur1");
    }


    @Test
    public void testUserSetUsername(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        String newUsername = "SelinTasman1";

        user.setUsername(newUsername);
        String updatedUsername = user.getUsername();

        assertEquals(updatedUsername, "SelinTasman1");
    }

    @Test
    public void testUserGetWeight(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        Double takenWeight = user.getWeight();


        assertEquals(takenWeight, 123.0);
    }

    @Test
    public void testUserSetWeight(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        Double newWeight = 500.0;
        user.setWeight(newWeight);
        Double updatedWeight = user.getWeight();

        assertEquals(updatedWeight, 500.0);
    }

    @Test
    public void testUserGetHeight(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        Double takenHeight = user.getHeight();

        assertEquals(takenHeight, 321.0);
    }

    @Test
    public void testUserSetHeight(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        Double newHeight = 750.0;

        user.setHeight(newHeight);

        Double updatedHeight = user.getHeight();

        assertEquals(updatedHeight, 750.0);
    }

    @Test
    public void testUserGetSex(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        String takenSex = user.getSex();

        assertEquals(takenSex, "Female");
    }

    @Test
    public void testUserSetSex(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        String newSex = "Other";

        user.setSex(newSex);

        String updatedSex = user.getSex();

        assertEquals(updatedSex, "Other");
    }

    @Test
    public void testUserGetBirthday(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        String takenBirthday = user.getBirthday();

        assertEquals(takenBirthday, "2003-08-20");
    }

    @Test
    public void testUserGetPassword(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        String takenPassword = user.getPassword();

        assertEquals(takenPassword, "Hello1");
    }

    @Test
    public void testUserSetPassword(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        String newPassword = "leave123";
        user.setPassword(newPassword);

        String updatedPassword = user.getPassword();

        assertEquals(updatedPassword, "leave123");
    }

    @Test
    public void testUserGetRepeatedPassword(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        String takenPassword = user.getRepeatPassword();

        assertEquals(takenPassword, "Hello1");
    }

    @Test
    public void testUserSetRepeatedPassword(){
        User user = new User("dinalojpur1", "Hello1", "Hello1", 321.0, 123.0, "Female", "2003-08-20");
        String newRepeatedPassword = "BBandLjuba1";

        user.setRepeatPassword(newRepeatedPassword);

        String updatedRepeatedPassword = user.getRepeatPassword();

        assertEquals(updatedRepeatedPassword, "BBandLjuba1");
    }
}
