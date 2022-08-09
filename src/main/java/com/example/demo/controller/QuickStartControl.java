package com.example.demo.controller;

import com.example.demo.mapper.UserGroupMapper;
import com.example.demo.pojo.UserToGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuickStartControl {

    @Autowired
    UserGroupMapper userGroupMapper;

    @RequestMapping("/quick")
    @ResponseBody
    public String quick(){
        userGroupMapper.addUserToGroup(new UserToGroup(40,1,"member"));
        return "Welcome to InkBook";
    }
}
