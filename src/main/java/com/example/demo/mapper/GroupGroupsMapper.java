package com.example.demo.mapper;

import com.example.demo.pojo.GroupToGroups;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GroupGroupsMapper {
    List<GroupToGroups> queryGroupGroupsList();

    GroupToGroups searchGroupByGroupsId(int groupsId);

    GroupToGroups searchGroupsByGroupId(int groupId);

    int addGroupGroups(GroupToGroups groupToGroups);

    int deleteGroupGroups(GroupToGroups groupToGroups);
}
