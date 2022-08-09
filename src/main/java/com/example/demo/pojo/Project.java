package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private int projectId;
    private String projectName;
    private int groupId;

    public Project(String projectName, int groupId){
        this.projectName = projectName;
        this.groupId = groupId;
    }


}
