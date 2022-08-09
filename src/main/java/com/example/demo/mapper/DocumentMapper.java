package com.example.demo.mapper;

import com.example.demo.pojo.Document;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DocumentMapper {

    List<Document> queryDocumentList();

    int createDocument(Document document);

    int deleteDocument(int documentId);

    int updateDocumentName(Document document);

    Document searchDocumentById(int documentId);

    List<Document> searchProjectDocuments(int projectId);
}
