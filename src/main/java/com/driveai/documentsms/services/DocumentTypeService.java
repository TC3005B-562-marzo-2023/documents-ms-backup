package com.driveai.documentsms.services;

import com.driveai.documentsms.dto.DocumentRequest;
import com.driveai.documentsms.models.Document;
import com.driveai.documentsms.models.DocumentType;
import com.driveai.documentsms.repositories.DocumentRepository;
import com.driveai.documentsms.repositories.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentTypeService {
    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    private DocumentTypeRepository documentTypeRepository;


    public DocumentType createDocumentType(DocumentType document) throws Exception{ //Add document
        //Check if there already is a document type with the same dealership and description
        DocumentType existingDocType = documentTypeRepository.findByDescriptionAndDealership(document.getDescription(), document.getDealership());
        if (existingDocType != null) {
            throw new Exception("There is already a document type with the same dealership and description.");
        }

        return documentTypeRepository.save(document); //Save document object
    }

    public DocumentType updateDocumentType(DocumentType document) throws Exception {
        Optional<DocumentType> documentInDB = documentTypeRepository.findById(document.getId());
        if (!documentInDB.isPresent()) {
            throw new Exception("Dont exist document type with that Id");
        }
        document = documentTypeRepository.save(document);

        return document; //Save document object
    }

    public void deleteDocumentType(int id) throws Exception {
        Optional<DocumentType> document = documentTypeRepository.findById(id);
        if (document.isPresent()) {
            documentTypeRepository.delete(document.get());
        } else {
            throw new Exception("document with id: " + id + " doesn't exist");
        }
    }
}
