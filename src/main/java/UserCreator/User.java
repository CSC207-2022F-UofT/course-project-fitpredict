package UserCreator;
import java.time.LocalDateTime;

public class User {
    String username;
    String password;
    String repeatPassword;
    Float weight;
    Float height;
    String sex;
    LocalDateTime birthday;

    public User(String username, String password,String repeatPassword,  Float weight, Float height, String sex,
                LocalDateTime birthday) {
        this.username = username;
        this.password = password;
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.birthday = birthday;
        this.repeatPassword = repeatPassword;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public Float getWeight(){
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getHeight(){
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getSex(){
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDateTime getBirthday(){
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.password = repeatPassword;
    }
}

