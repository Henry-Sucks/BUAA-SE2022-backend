package com.example.demo.mapper;

import com.example.demo.pojo.Project;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface ProjectMapper {

    List<Project> queryProjectList();

    Project searchProjectById(int projectId);

    Project searchProjectByName(String projectName);

    Project searchProjectByGroup(int groupId);

    //Project searchProjectByUser(int userId);

    int addProject(Project project);


    int deleteProject(Project project);
}