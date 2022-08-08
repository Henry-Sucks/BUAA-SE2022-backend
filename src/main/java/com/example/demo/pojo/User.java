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
    private String createdTime = null;

    private void timeInit(){
        if(createdTime == null){
            Date now = new Date();
            createdTime = now.toString();
        }
    }

    public User(String name, String Email, String passWord){
        timeInit();
        this.userName = name;
        this.userEmail = Email;
        this.userPassWord = passWord;
    }

    public User(int userId, String userName, String userEmail, int userPhoneNumber,
               String userPassWord, String userIcon, String userRealName,
               String userCareer, String userUnit, String userBirthday,
                String userLocation, String userUrl) {
        timeInit();
        this.userId = userId;
       this.userName = userName;
       this.userEmail = userEmail;
       this.userPhoneNumber = userPhoneNumber;
       this.userPassWord = userPassWord;
       this.userIcon = userIcon;
       this.userRealName = userRealName;
       this.userCareer = userCareer;
       this.userUnit = userUnit;
       this.userBirthday = userBirthday;
       this.userLocation = userLocation;
       this.userUrl = userUrl;

    }
}


