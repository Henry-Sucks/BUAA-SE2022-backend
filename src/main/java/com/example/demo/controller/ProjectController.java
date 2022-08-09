package com.example.demo.controller;

import com.example.demo.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.pojo.Project;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    ProjectMapper projectMapper;

    // 查询所有项目
    public List<Project> queryProjectList(){
        return projectMapper.queryProjectList();
    }

    // 通过id查询项目
    public Project searchProjectById(int projectId){
        return projectMapper.searchProjectById(projectId);
    }

    // 通过项目名称查询项目
    public Project searchProjectByName(String projectName){
        return projectMapper.searchProjectByName(projectName);
    }

    // 通过团队Id查询项目
    public Project searchProjectByGroup(int groupId){
        return projectMapper.searchProjectByGroup(groupId);
    }

    // 创建项目
    public void addProject(String name, int groupId){
        Project temp = new Project(name, groupId);
        projectMapper.addProject(temp);
    }

    // 根据项目ID删除项目
    public void deleteProject(int projectId){
        Project temp = searchProjectById(projectId);
        projectMapper.deleteProject(temp);
    }



}
