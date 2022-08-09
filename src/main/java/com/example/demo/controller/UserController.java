package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.DataReturn;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController


@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    //查询所有的user
    @GetMapping
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        for (User user : userList){
            System.out.println(user);
        }
        return userList;
    }

    //用户名登录：检查登录 返回-1表示用户不存在，返回0表示密码错误，返回1表示密码正确
    @GetMapping("checkPw")
    public DataReturn<Integer> checkLoginById(int userId, String passWord){
        DataReturn<Integer> dataReturn = new DataReturn<Integer>();
        User temUser = userMapper.searchUserById(userId);
        if (temUser == null){
            dataReturn.setData(-1);
            dataReturn.setResult(false);
            dataReturn.setErrorInf("用户不存在");
            return dataReturn;
        }
        String psw = temUser.getUserPassWord();
        if (psw.equals(passWord)){
            dataReturn.setData(1);
            dataReturn.setResult(true);
            return dataReturn;
        }else{
            dataReturn.setData(0);
            dataReturn.setResult(false);
            dataReturn.setErrorInf("密码错误");
            return dataReturn;
        }
    }

    //邮箱登录
    @GetMapping("/loginByEmail")
    public DataReturn<Integer> checkLoginByEmail(String userEmail, String passWord){
        User temUser = userMapper.searchUserByEmail(userEmail);
        DataReturn<Integer> dataReturn = new DataReturn<Integer>();
        if (temUser == null){
            dataReturn.setData(-1);
            dataReturn.setResult(false);
            dataReturn.setErrorInf("用户不存在");
            return dataReturn;
        }
        String psw = temUser.getUserPassWord();
        System.out.println(psw);
        System.out.println(passWord);
        System.out.println(psw+ "  " + passWord);
        if (psw.equals(passWord)){
            dataReturn.setData(1);
            dataReturn.setResult(true);

            return dataReturn;
        }else{
            dataReturn.setData(0);
            dataReturn.setResult(false);
            dataReturn.setErrorInf("密码错误");
            return dataReturn;
        }
    }

    //通过Id查找用户 返回User类，如果用户不存在返回null，用户信息可以由相应的get方法获得
    @GetMapping("/findUserById")
    public DataReturn<User> getUserInfById(int userId){
        DataReturn<User> dataReturn = new DataReturn<>();
        User temUser = userMapper.searchUserById(userId);
        if (temUser == null){
            dataReturn.setResult(false);
            dataReturn.setErrorInf("用户不存在");
            dataReturn.setData(null);
        }else{
            dataReturn.setResult(true);
            dataReturn.setData(temUser);
        }
        return dataReturn;
    }

    //通过Email查找用户
    @GetMapping("/findEmail")
    public DataReturn<User> getUserInfByEmail(String userEmail){
        User temUser =  userMapper.searchUserByEmail(userEmail);
        DataReturn dataReturn = new DataReturn<>();
        if (temUser == null){
            dataReturn.setResult(false);
            dataReturn.setErrorInf("用户不存在");
            dataReturn.setData(null);
        }else{
            dataReturn.setData(temUser);
            dataReturn.setResult(true);
        }
        return dataReturn;
    }


    @GetMapping("/findName")
    //通过Name查找用户
    public DataReturn<List<User>> getUserInfByName(String userName){
        List<User> temUser =  userMapper.searchUserByName(userName);
        DataReturn dataReturn = new DataReturn<>();
        if (temUser.size() == 0){
            dataReturn.setResult(false);
            dataReturn.setErrorInf("用户不存在");
            dataReturn.setData(null);
        }else{
            dataReturn.setData(temUser);
            dataReturn.setResult(true);
        }
        return dataReturn;
    }

    //更新用户信息
    @PostMapping("/update")
    public DataReturn<Integer> updateInf(int userId, String userName, String userEmail,
                String userIcon, String userRealName,
                String userCareer, String userUnit, String userBirthday,
                String userLocation, String userUrl){
        User temUser = new User(userId,userName,userEmail,
                userIcon, userRealName,
                userCareer, userUnit, userBirthday,
                userLocation, userUrl);
        DataReturn<Integer> dataReturn = new DataReturn<>();
        if (userMapper.updateUser(temUser) == 0){
            dataReturn.setResult(false);
            dataReturn.setErrorInf("更新失败");
        }else{
            dataReturn.setResult(true);
        }
        return dataReturn;

    }

    //添加用户 返回用户的id
    @PostMapping("addUser")
    public DataReturn<Integer> register(String userName, String Email, String passWord){
        User temUser = new User(userName, Email, passWord);
        DataReturn<Integer> dataReturn = new DataReturn<>();
        Calendar now = Calendar.getInstance();
        String time = now.get(Calendar.YEAR) + "-" + now.get(Calendar.MONTH)
                + "-" + now.get(Calendar.DAY_OF_MONTH);
        temUser.setCreateTime(time);
        int res = userMapper.addUser(temUser);
        if (res == 0){
            dataReturn.setResult(false);
            dataReturn.setErrorInf("注册失败");
            dataReturn.setData(0);
        }else{
            dataReturn.setResult(true);
            dataReturn.setData(temUser.getUserId());
        }
        return dataReturn;
    }

    //检查用户邮箱格式
    public boolean checkEmail(String userEmail){

        String RULE_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        Pattern p = Pattern.compile(RULE_EMAIL);
        Matcher m = p.matcher(userEmail);
        return m.matches();

    }

}
