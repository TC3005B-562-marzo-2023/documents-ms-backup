package com.driveai.documentsms.dto;

public class DocumentRequest {
    private int userId;
    private String link;
    private int referenceTable;
    private int documentTypeId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(int documentTypeId) {
        this.documentTypeId = documentTypeId;
    }
}
