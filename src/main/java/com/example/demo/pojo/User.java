package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int userId;
    private String userName;
    private String userEmail;
    private int userPhoneNumber;
    private String userPassWord;
    private String userIcon;
    private String userRealName;
    private String userCareer;
    private String userUnit;
    private String userBirthday;
    private String userLocation;
    private String userUrl;

    public User(String name, String Email, String passWord){
        this.userName = name;
        this.userEmail = Email;
        this.userPassWord = passWord;
    }

}


