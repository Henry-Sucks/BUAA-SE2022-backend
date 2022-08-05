package com.example.demo.mapper;

import com.example.demo.pojo.Group;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GroupMapper {

    List<Group> queryGroupList();

    List<Group> searchGroupByName(String name);

    Group searchGroupById(int groupId);

    int addGroup(Group group);

    int updateGroup(Group group);

    int deleteGroup(int groupId);

}
