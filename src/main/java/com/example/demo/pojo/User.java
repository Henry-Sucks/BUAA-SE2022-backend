package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public final class User {
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
    private String createTime;

    public User(String name, String Email, String passWord){
        this.userName = name;
        this.userEmail = Email;
        this.userPassWord = passWord;
    }

    public User(int userId, String userName, String userEmail,
                String userIcon, String userRealName,
                String userCareer, String userUnit, String userBirthday,
                String userLocation, String userUrl) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userIcon = userIcon;
        this.userRealName = userRealName;
        this.userCareer = userCareer;
        this.userUnit = userUnit;
        this.userBirthday = userBirthday;
        this.userLocation = userLocation;
        this.userUrl = userUrl;
    }
}


