package com.driveai.documentsms.services;

import com.driveai.documentsms.dto.DocumentRequest;
import com.driveai.documentsms.models.Document;
import com.driveai.documentsms.models.DocumentType;
import com.driveai.documentsms.repositories.DocumentRepository;
import com.driveai.documentsms.repositories.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {
    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public Document createDocument(DocumentRequest doc) throws Exception {
        //Check if there already is a document with same link and user
        Document existingDoc = documentRepository.findByLinkAndUserId(doc.getLink(), doc.getUserId());
        if (existingDoc != null) {
            throw new Exception("There is already a document with the same link and user.");
        }

        //Check if document type exists
        DocumentType documentType = documentTypeRepository.findById(doc.getDocumentTypeId())
                .orElseThrow(() -> new Exception("Document Type not Found."));

        //If everything OK then create document
        Document newDocument = new Document(doc, documentTypeRepository);
        return documentRepository.save(newDocument);
    }

    public DocumentType createDocumentType(DocumentType document) throws Exception{ //Add document
        //Check if there already is a document type with the same dealership and description
        DocumentType existingDocType = documentTypeRepository.findByDescriptionAndDealership(document.getDescription(), document.getDealership());
        if (existingDocType != null) {
            throw new Exception("There is already a document type with the same dealership and description.");
        }

        return documentTypeRepository.save(document); //Save document object
    }

    public void deleteDocument (int id) throws Exception {
        Optional<Document> document = documentRepository.findById(id);
        if (document.isPresent()) {
            documentRepository.delete(document.get());
        } else {
            throw new Exception("document with id: " + id + " doesn't exist");
        }
    }

    public void deleteDocumentType(int id) throws Exception {
        Optional<DocumentType> document = documentTypeRepository.findById(id);
        if (document.isPresent()) {
            documentTypeRepository.delete(document.get());
        } else {
            throw new Exception("document with id: " + id + " doesn't exist");
        }
    }

    public Document showById(int id) throws Exception {
        Optional<Document> document = documentRepository.findById(id);
        if(document.isPresent()) {
            return document.get();
        } else {
            throw new Exception("Todo " + id + " does not exist");
        }
    }
}
