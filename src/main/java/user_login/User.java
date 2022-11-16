package user_login;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {

    public User(String username, String password,String repeatPassword,  Float weight, Float height, String sex,
                LocalDate birthday) {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight){
    }

    public Float getHeight(){
        return height;
    }

    public void setHeight(Float height){
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex){
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
    }

    public String getRepeatPassword(){
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword){
    }

    public boolean checkPasswordMatches(String password){
        return true;
    }


}


