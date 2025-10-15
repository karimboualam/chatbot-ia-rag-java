package com.chatbot.chatbot.repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import com.chatbot.chatbot.model.Document;

@Repository
public class DocumentRepository {
    private final List<Document> documents = new ArrayList<>();

    public List<Document> findAll() {
        return documents;
    }

    public void save(Document doc) {
        documents.add(doc);
    }
}
