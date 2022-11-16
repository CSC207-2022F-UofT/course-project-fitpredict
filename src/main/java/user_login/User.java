package user_login;

import java.io.Serializable;
import java.time.LocalDateTime;

public class User implements Serializable {

    public User(String username, String password,String repeatPassword,  Float weight, Float height, String sex,
                LocalDateTime birthday) {
    }

    public String getUsername() {
    }

    public void setUsername(String username) {
    }

    public Float getWeight() {
    }

    public void setWeight(Float weight){
    }

    public Float getHeight(){
    }

    public void setHeight(Float height){
    }

    public String getSex() {
    }

    public void setSex(String sex){
    }

    public LocalDateTime getBirthday() {
    }

    public String getPassword(){
    }

    public void setPassword(String password){
    }

    public String getRepeatPassword(){
    }

    public void setRepeatPassword(String repeatPassword){
    }

    public boolean checkPasswordMatches(String password){
    }

    public boolean checkUsernameMatches(String username){
    }


}


