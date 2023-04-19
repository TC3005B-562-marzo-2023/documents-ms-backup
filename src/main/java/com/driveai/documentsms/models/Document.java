package com.driveai.documentsms.models;

import com.driveai.documentsms.dto.DocumentRequest;
import com.driveai.documentsms.repositories.DocumentTypeRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private int userId;
    private String link;
    private int referenceTable;

    @ManyToOne
    @JoinColumn(name = "document_type")
    @JsonIgnore
    private DocumentType documentType;

    public Document(DocumentRequest documentDto, DocumentTypeRepository documentTypeRepository) {
        this.userId = documentDto.getUserId();
        this.link = documentDto.getLink();
        this.referenceTable = documentDto.getReferenceTable();
        this.documentType = documentTypeRepository.findById(documentDto.getDocumentTypeId())
                .orElseThrow(() -> new RuntimeException("DocumentType not found"));
    }

    public Document() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int user_id) {
        this.userId = user_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getReferenceTable() {
        return referenceTable;
    }

    public void setReferenceTable(int referenceTable) {
        this.referenceTable = referenceTable;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType docType) {
        this.documentType = docType;
    }
}
