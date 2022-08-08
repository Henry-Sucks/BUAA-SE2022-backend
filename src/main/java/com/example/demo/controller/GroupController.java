package com.example.demo.controller;

import com.example.demo.mapper.GroupMapper;
import com.example.demo.mapper.UserGroupMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.DataReturn;
import com.example.demo.pojo.Group;
import com.example.demo.pojo.User;
import com.example.demo.pojo.UserToGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
//http://localhost:9090/user/createGroup
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupMapper groupMapper;
    UserGroupMapper userGroupMapper;
    UserMapper userMapper;

    //查询所有组
    public DataReturn<List<Group>> queryGroupList(){
        List<Group> groupList = groupMapper.queryGroupList();
        DataReturn<List<Group>> dataReturn = new DataReturn<List<Group>>();
        if (groupList.size() == 0){
            dataReturn.setResult(false);
            dataReturn.setErrorInf("没有组群");
        }else{
            dataReturn.setData(groupList);
            dataReturn.setResult(true);
        }
        return dataReturn;
    }


    //通过id查询群组
    public DataReturn<Group> getGroupById(int groupId){
        Group group = groupMapper.searchGroupById(groupId);
        DataReturn<Group> dataReturn = new DataReturn<>();
        if (group == null){
            dataReturn.setResult(false);
            dataReturn.setErrorInf("小组不存在");
        }else{
            dataReturn.setData(group);
            dataReturn.setResult(true);
        }
        return  dataReturn;
    }

<<<<<<< HEAD
    //创建一个组
    @PostMapping("/createGroup")
    public void createGroup(User founder, String name){
=======
    //通过名字查询组群

    public DataReturn<List<Group>> getGroupByName(String groupName){
        List<Group> groupList =  groupMapper.searchGroupByName(groupName);
        DataReturn<List<Group>> dataReturn = new DataReturn<>();
        if(groupList.size() == 0){
            dataReturn.setResult(false);
            dataReturn.setErrorInf("小组不存在");
        }else{
            dataReturn.setData(groupList);
            dataReturn.setResult(true);
        }
        return dataReturn;
    }

    //查找某用户加入的组 注意返回值可能为null
    public DataReturn<List<Group>> getGroupOfUserById(int userId){
        List<UserToGroup> temUserToGroup = userGroupMapper.searchGroupIdByUserId(userId);
        List<Group> groupList = new ArrayList<Group>();
        DataReturn<List<Group>> dataReturn = new DataReturn<>();
        for (UserToGroup ug : temUserToGroup){
            int temGroupId = ug.getGroupId();
            Group temGroup  = groupMapper.searchGroupById(temGroupId);
            groupList.add(temGroup);
        }
        if (groupList.size() == 0){
            dataReturn.setResult(false);
            dataReturn.setErrorInf("用户没有加入小组");
        }else{
            dataReturn.setResult(true);
            dataReturn.setData(groupList);
        }
        return dataReturn;
    }

    //查找某群里所有用户
    public DataReturn<List<User>> getUserInGroupById(int groupId){
        List<UserToGroup> temUserToGroup = userGroupMapper.searchUserIdByGroupId(groupId);
        List<User> userList = new ArrayList<User>();
        DataReturn<List<User>> dataReturn = new DataReturn<>();
        for (UserToGroup ug : temUserToGroup){
            int temUserId = ug.getUserId();
            User temUser  = userMapper.searchUserById(temUserId);
            userList.add(temUser);
        }
        if (userList.size() == 0){
            dataReturn.setResult(false);
            dataReturn.setErrorInf("组里还没有成员");
        }else{
            dataReturn.setResult(true);
            dataReturn.setData(userList);
        }
        return dataReturn;
    }

    //创建一个组 返回组的id
    public DataReturn<Integer> createGroup(User founder, String name){
>>>>>>> WGX
        Group temGroup = new Group(name);
        DataReturn<Integer> dataReturn = new DataReturn<>();
        int groupId = temGroup.getGroupId();
        int userId = founder.getUserId();
        temGroup.setGroupId(groupId);
        groupMapper.addGroup(temGroup);
        UserToGroup temUserGroup = new UserToGroup(userId, groupId,"founder");
        int res = userGroupMapper.addUserToGroup(temUserGroup);
        if (res == 0){
            dataReturn.setResult(false);
            dataReturn.setErrorInf("创建失败");
        }else{
            dataReturn.setData(groupId);
            dataReturn.setResult(true);
        }
        return dataReturn;
    }

    //向组内添加成员
    public DataReturn<Integer>  addMember(int userId, int groupId, String job){
        UserToGroup temUserGroup = new UserToGroup(userId, groupId, job);
        int res = userGroupMapper.addUserToGroup(temUserGroup);
        DataReturn<Integer> dataReturn = new DataReturn<>();
        if (res == 0){
            dataReturn.setResult(false);
            dataReturn.setData(0);
            dataReturn.setErrorInf("添加失败");
        }else{
            dataReturn.setData(1);
            dataReturn.setResult(true);
        }
        return dataReturn;
    }

    //删除组内成员
    public DataReturn<Integer> deleteMember(int userId, int groupId, String job){
        UserToGroup temUserGroup = new UserToGroup(userId, groupId, job);
        int res = userGroupMapper.deleteUserToGroup(temUserGroup);
        DataReturn<Integer> dataReturn = new DataReturn<>();
        if (res == 0){
            dataReturn.setResult(false);
            dataReturn.setData(0);
            dataReturn.setErrorInf("添加失败");
        }else{
            dataReturn.setData(1);
            dataReturn.setResult(true);
        }
        return dataReturn;
    }

    //更改成员身份
    public DataReturn<Integer>  updateMember(int userId, int groupId, String job){
        UserToGroup temUserGroup = new UserToGroup(userId, groupId, job);
        int res = userGroupMapper.updateUserToGroup(temUserGroup);
        DataReturn<Integer> dataReturn = new DataReturn<>();
        if (res == 0){
            dataReturn.setResult(false);
            dataReturn.setData(0);
            dataReturn.setErrorInf("添加失败");
        }else{
            dataReturn.setData(1);
            dataReturn.setResult(true);
        }
        return dataReturn;
    }
}
