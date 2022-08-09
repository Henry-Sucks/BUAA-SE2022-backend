package com.example.demo.mapper;

import com.example.demo.pojo.UserToGroup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserGroupMapper {
    List<UserToGroup> queryUserToGroupList();

    List<UserToGroup> searchGroupIdByUserId(int userId);

    List<UserToGroup> searchUserIdByGroupId(int groupId);

    String searchUserJobById(int userId, int groupId);

    int addUserToGroup(UserToGroup userToGroup);

    int deleteUserToGroup(UserToGroup userToGroup);

    int deleteGroup(int groupId);

    int updateUserToGroup(UserToGroup userToGroup);
}
