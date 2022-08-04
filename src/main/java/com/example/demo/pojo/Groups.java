package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Groups {
    private int userGroupsId;
    private String userGroupsName;
    private String  userGroupsIcon;
}
