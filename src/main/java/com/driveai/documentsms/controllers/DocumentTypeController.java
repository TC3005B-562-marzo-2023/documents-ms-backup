package com.driveai.documentsms.controllers;

import com.driveai.documentsms.dto.DocumentRequest;
import com.driveai.documentsms.models.Document;
import com.driveai.documentsms.models.DocumentType;
import com.driveai.documentsms.services.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/document-type") //  ruta
public class DocumentTypeController {
    @Autowired
    DocumentTypeService documentTypeService;

    @PostMapping("/create/documentType")
    public ResponseEntity<?> createDocumentType (@RequestBody DocumentType document) {
        try {
            DocumentType newDoc = documentTypeService.createDocumentType(document);
            return new ResponseEntity<>(newDoc, HttpStatus.OK);
        }
        catch (Exception e) {
            Map<String,String> response = new HashMap<>();
            response.put("message", "Document Type could not be created: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateDocumentType (@RequestBody DocumentType document) {
        try {
            DocumentType newDoc = documentTypeService.updateDocumentType(document);
            return new ResponseEntity<>(newDoc, HttpStatus.OK);
        }
        catch (Exception e) {
            Map<String,String> response = new HashMap<>();
            response.put("message", "Document Type could not be created: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/delete/documentType")
    public ResponseEntity<?> deleteDocumentType(@RequestParam("id") int id) {
        try { documentTypeService.deleteDocumentType(id); }
        catch (Exception e) {
            Map<String,String> response = new HashMap<>();
            response.put("message", "Document Type could not be deleted: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String message = "Document Type with id: " + id + " deleted";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
