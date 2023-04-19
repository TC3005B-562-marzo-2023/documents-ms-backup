package com.driveai.documentsms.services;

import com.driveai.documentsms.dto.DocumentRequest;
import com.driveai.documentsms.models.Document;
import com.driveai.documentsms.repositories.DocumentRepository;
import com.driveai.documentsms.repositories.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.QueryRewriter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentService {
    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    public Document createDocument (DocumentRequest doc) {
        Document newDocument = new Document(doc, documentTypeRepository);
        return documentRepository.save(newDocument);
    }

    public void deleteDocument (int id) throws Exception {
        Optional<Document> document = documentRepository.findById(id);
        if (document.isPresent()) {
            documentRepository.delete(document.get());
        } else {
            throw new Exception("document with id: " + id + " doesn't exist");
        }
    }
}
