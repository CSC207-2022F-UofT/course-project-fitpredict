package User;
import java.time.LocalDateTime;

public class User {
    String Username;
    String Password;
    Float Weight;
    Float Height;
    LocalDateTime Birthday;

    public User(String User, String Password) {
        this.Username = Username;
        this.Password = Password;
        this.Weight = Weight;
        this.Height = Height;
        this.Birthday = Birthday;
    }

    public String getUsername(){
        return this.Username;
    }

}
