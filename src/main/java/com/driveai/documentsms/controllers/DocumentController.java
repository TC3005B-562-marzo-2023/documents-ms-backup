package com.driveai.documentsms.controllers;

import com.driveai.documentsms.dto.DocumentRequest;
import com.driveai.documentsms.models.Document;
import com.driveai.documentsms.models.DocumentType;
import com.driveai.documentsms.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    DocumentService documentService;

    @PostMapping("/create/document")
    public ResponseEntity<?> createDocument (@RequestBody DocumentRequest document) {
        try {
            Document newDoc = documentService.createDocument(document);
            return new ResponseEntity<>(newDoc, HttpStatus.OK);
        }
        catch (Exception e) {
            Map<String,String> response = new HashMap<>();
            response.put("message", "Document could not be created: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create/documentType")
    public ResponseEntity<?> createDocumentType (@RequestBody DocumentType document) {
        try {
            DocumentType newDoc = documentService.createDocumentType(document);
            return new ResponseEntity<>(newDoc, HttpStatus.OK);
        }
        catch (Exception e) {
            Map<String,String> response = new HashMap<>();
            response.put("message", "Document Type could not be created: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/document")
    public ResponseEntity<?> deleteDocument(@RequestParam("id") int id) {
        try { documentService.deleteDocument(id); }
        catch (Exception e) {
            Map<String,String> response = new HashMap<>();
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String message = "Document with id: " + id + " deleted";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/delete/documentType")
    public ResponseEntity<?> deleteDocumentType(@RequestParam("id") int id) {
        try { documentService.deleteDocumentType(id); }
        catch (Exception e) {
            Map<String,String> response = new HashMap<>();
            response.put("message", "Document Type could not be deleted: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String message = "Document Type with id: " + id + " deleted";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/show/document")
    public ResponseEntity<List<Document>> getAllDocuments() {
        return ResponseEntity.ok(documentService.getAllDocuments());
    }

}
