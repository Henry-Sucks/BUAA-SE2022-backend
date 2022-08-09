package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {
    private int documentId;
    private String documentName;
    private String documentPath;
    //private int projectId;
    private int userId;
    private String createTime;
}
