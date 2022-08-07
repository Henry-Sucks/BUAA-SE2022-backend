package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    //查询所有的user
    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        int a = userMapper.addUser(new User("123","123@qq.com","123"));
        System.out.println(a);
        List<User> userList = userMapper.queryUserList();
        for (User user : userList){
            System.out.println(user);
        }
        return userList;
    }

    //用户名登录：检查登录 返回-1表示用户不存在，返回0表示密码错误，返回1表示密码正确
    public int checkLoginById(int userId, String passWord){
        User temUser = userMapper.searchUserById(userId);
        if (temUser == null){
            return -1;
        }
        String psw = temUser.getUserPassWord();
        if (psw.equals(passWord)){
            return 1;
        }else{
            return 0;
        }
    }

    //邮箱登录
    public int checkLoginByEmail(String userEmail, String passWord){
        User temUser = userMapper.searchUserByEmail(userEmail);
        if (temUser == null){
            return -1;
        }
        String psw = temUser.getUserPassWord();
        if (psw.equals(passWord)){
            return 1;
        }else{
            return 0;
        }
    }

    //通过Id查找用户 返回User类，如果用户不存在返回null，用户信息可以由相应的get方法获得
    public User getUserInfById(int userId){
        return userMapper.searchUserById(userId);
    }

    //通过Email查找用户
    public User getUserInfByEmail(String userEmail){
        return userMapper.searchUserByEmail(userEmail);
    }

    //通过Name查找用户
    public List<User> getUserInfByName(String userName){
        return userMapper.searchUserByName(userName);
    }

    //更新用户信息
    public void updateInf(int userId, String userName, String userEmail, int userPhoneNumber,
                String userPassWord, String userIcon, String userRealName,
                String userCareer, String userUnit, String userBirthday,
                String userLocation, String userUrl){
        User temUser = new User(userId,userName,userEmail,userPhoneNumber,
                userPassWord, userIcon, userRealName,
                userCareer, userUnit, userBirthday,
                userLocation, userUrl);
        userMapper.updateUser(temUser);

    }

    //添加用户 返回用户的id
    public int register(String userName, String Email, String passWord){
        User temUser = new User(userName, Email, passWord);
        userMapper.addUser(temUser);
        return temUser.getUserId();
    }

    //检查用户邮箱格式
    public boolean checkEmail(String userEmail){

        String RULE_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        Pattern p = Pattern.compile(RULE_EMAIL);
        Matcher m = p.matcher(userEmail);
        return m.matches();

    }

}
