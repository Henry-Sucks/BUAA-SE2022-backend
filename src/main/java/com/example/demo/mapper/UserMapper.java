package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> queryUserList();

    //用用户Id查询用户信息
    User searchUserById(int userId);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int userId);
}
