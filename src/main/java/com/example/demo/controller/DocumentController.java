package com.example.demo.controller;

import com.example.demo.mapper.DocumentMapper;
import com.example.demo.pojo.DataReturn;
import com.example.demo.pojo.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController


@RequestMapping("/document")
public class DocumentController {
    @Autowired
    private DocumentMapper documentMapper;

    //创建文档
    @PostMapping("/createDocument")
    public DataReturn<Integer> createDocument(int projectId, String documentName, String documentPath){
        DataReturn<Integer> dataReturn = new DataReturn<>();
        Document document = new Document();
        document.setDocumentName(documentName);
        document.setDocumentPath(documentPath);
        document.setProjectId(projectId);
        Calendar now = Calendar.getInstance();
        String time = now.get(Calendar.YEAR) + "-" + now.get(Calendar.MONTH) +
                "-" + now.get(Calendar.DAY_OF_MONTH);
        document.setCreateTime(time);
        int res = documentMapper.createDocument(document);
        int documentId = document.getDocumentId();
        if (res == 0){
            dataReturn.setResult(false);
            dataReturn.setErrorInf("文档创建失败");
        }else{
            dataReturn.setData(documentId);
            dataReturn.setResult(true);
        }
        return dataReturn;
    }

    //删除文档
    @PostMapping("/deleteDocument")
    public DataReturn<Integer> deleteDocument(int documentId){
        DataReturn<Integer> dataReturn = new DataReturn<>();
        int res = documentMapper.deleteDocument(documentId);
        if (res == 0){
            dataReturn.setResult(false);
            dataReturn.setErrorInf("文档删除失败");
        }else{
            dataReturn.setResult(true);
            dataReturn.setData(1);
        }
        return dataReturn;

    }

    //更新文档名称
    @PostMapping("/updateDocument")
    public DataReturn<Integer> updateDocument(int documentId, String documentName){
        DataReturn<Integer> dataReturn = new DataReturn<>();
        Document document = new Document();
        document.setDocumentId(documentId);
        document.setDocumentName(documentName);
        int res = documentMapper.updateDocumentName(document);
        if (res == 0){
            dataReturn.setResult(false);
            dataReturn.setErrorInf("文档名称更新失败");
        }else{
            dataReturn.setResult(true);
        }
        return dataReturn;
    }

}
