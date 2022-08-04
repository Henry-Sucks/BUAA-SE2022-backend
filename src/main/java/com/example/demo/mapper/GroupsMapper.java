package com.example.demo.mapper;

import com.example.demo.pojo.Group;
import com.example.demo.pojo.Groups;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GroupsMapper {

    List<Group> queryGroupsList();

    Group searchGroupsById(int userGroupsId);

    int addGroups(Groups groups);

    int updateGroups(Groups groups);

    int deleteGroups(int userGroupsId);

}
