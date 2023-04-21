package com.driveai.documentsms.repositories;

import com.driveai.documentsms.models.Document;
import com.driveai.documentsms.models.DocumentType;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DocumentRepository extends CrudRepository<Document, Integer> {
    Optional<Document> findByUserId(int userId);

    Document findByLinkAndUserId(String link, int userId);

}
