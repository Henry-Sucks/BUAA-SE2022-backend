package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    private int groupId;
    private String groupName;
    private String groupInf;
    private String groupIcon;
    private String createdTime = null;
    private void initTime(){
        if(createdTime == null){
        Date now = new Date();
        createdTime = now.toString();
        }
    }
    public Group(String name){
        initTime();
        this.groupName = name;
    }
}
