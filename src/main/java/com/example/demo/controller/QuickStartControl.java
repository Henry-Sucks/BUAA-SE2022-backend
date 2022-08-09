package com.example.demo.controller;

import com.example.demo.mapper.UserGroupMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.pojo.UserToGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;

@Controller
public class QuickStartControl {

    @Autowired
    UserGroupMapper userGroupMapper;

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/quick")
    @ResponseBody
    public String quick(){
        Calendar now = Calendar.getInstance();
        String time = now.get(Calendar.YEAR) + "-" + now.get(Calendar.MONTH) + "-" + now.get(Calendar.DAY_OF_MONTH);
        //new GroupController().createGroup(40,"test");
        return time;
    }
}
