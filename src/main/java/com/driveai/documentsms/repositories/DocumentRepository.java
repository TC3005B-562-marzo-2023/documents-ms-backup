package com.driveai.documentsms.repositories;

import com.driveai.documentsms.models.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Document, Integer> {
}
