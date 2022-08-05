package com.example.demo.controller;

import com.example.demo.mapper.GroupMapper;
import com.example.demo.mapper.UserGroupMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.Group;
import com.example.demo.pojo.User;
import com.example.demo.pojo.UserToGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {
    @Autowired
    GroupMapper groupMapper;
    UserGroupMapper userGroupMapper;
    UserMapper userMapper;

    //查询所有组
    public List<Group> queryGroupList(){
        return groupMapper.queryGroupList();
    }


    //通过id查询群组
    public Group getGroupById(int groupId){
        return groupMapper.searchGroupById(groupId);
    }

    //通过名字查询组群

    public List<Group> getGroupByName(String groupName){
        return groupMapper.searchGroupByName(groupName);
    }

    //查找某用户加入的组 注意返回值可能为null
    public List<Group> getGroupOfUserById(int userId){
        List<UserToGroup> temUserToGroup = userGroupMapper.searchGroupIdByUserId(userId);
        List<Group> groupList = null;
        for (UserToGroup ug : temUserToGroup){
            int temGroupId = ug.getGroupId();
            Group temGroup  = groupMapper.searchGroupById(temGroupId);
            groupList.add(temGroup);
        }
        return groupList;
    }

    //查找某群里所有用户
    public List<User> getUserInGroupById(int groupId){
        List<UserToGroup> temUserToGroup = userGroupMapper.searchUserIdByGroupId(groupId);
        List<User> userList = null;
        for (UserToGroup ug : temUserToGroup){
            int temUserId = ug.getUserId();
            User temUser  = userMapper.searchUserById(temUserId);
            userList.add(temUser);
        }
        return userList;
    }

    //创建一个组
    public void createGroup(User founder, String name){
        Group temGroup = new Group(name);
        groupMapper.addGroup(temGroup);
        int groupId = temGroup.getGroupId();
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
