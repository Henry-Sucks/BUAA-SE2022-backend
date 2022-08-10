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
    private String createTime;

    public Group(String name){
        this.groupName = name;
    }
}
