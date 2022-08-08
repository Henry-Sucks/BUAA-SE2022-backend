package com.example.demo.controller;

import com.example.demo.mapper.GroupMapper;
import com.example.demo.mapper.UserGroupMapper;
import com.example.demo.pojo.Group;
import com.example.demo.pojo.User;
import com.example.demo.pojo.UserToGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//http://localhost:9090/user/createGroup
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupMapper groupMapper;
    UserGroupMapper userGroupMapper;

    //查询所有组
    public List<Group> queryGroupList(){
        return groupMapper.queryGroupList();
    }

    //通过id查询群组
    public Group getGroupById(int groupId){
        return groupMapper.searchGroupById(groupId);
    }

    //创建一个组
    @PostMapping("/createGroup")
    public void createGroup(User founder, String name){
        Group temGroup = new Group(name);
        int groupId = groupMapper.addGroup(temGroup);
        int userId = founder.getUserId();
        UserToGroup temUserGroup = new UserToGroup(userId, groupId,"founder");
        userGroupMapper.addUserToGroup(temUserGroup);
    }

    //向组内添加成员
    public void  addMember(int userId, int groupId, String job){
        UserToGroup temUserGroup = new UserToGroup(userId, groupId, job);
        userGroupMapper.addUserToGroup(temUserGroup);
    }

    //删除组内成员
    public void  deleteMember(int userId, int groupId, String job){
        UserToGroup temUserGroup = new UserToGroup(userId, groupId, job);
        userGroupMapper.deleteUserToGroup(temUserGroup);
    }

    //更改成员身份
    public void  updateMember(int userId, int groupId, String job){
        UserToGroup temUserGroup = new UserToGroup(userId, groupId, job);
        userGroupMapper.updateUserToGroup(temUserGroup);
    }
}
