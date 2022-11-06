package User;
import java.time.LocalDateTime;

public class User {
    String username;
    String password;
    Float weight;
    Float height;
    LocalDateTime birthday;

    public User(String User, String Password) {
        this.username = username;
        this.password = password;
        this.weight = weight;
        this.height = height;
        this.birthday = birthday;
    }

    public String getUsername(){
        return this.username;
    }

}
