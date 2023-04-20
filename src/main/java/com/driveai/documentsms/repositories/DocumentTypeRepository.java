package com.driveai.documentsms.repositories;

import com.driveai.documentsms.models.DocumentType;
import org.springframework.data.repository.CrudRepository;

public interface DocumentTypeRepository extends CrudRepository<DocumentType, Integer> {
    DocumentType findByDescriptionAndDealership(String description, int dealership);
}