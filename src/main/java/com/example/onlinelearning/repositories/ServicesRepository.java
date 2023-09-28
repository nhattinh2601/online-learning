package com.example.onlinelearning.repositories;

import com.example.onlinelearning.entities.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServicesRepository extends MongoRepository<Services, String> {

    Page<Services> findByIdContainingAllIgnoreCase(String search,  Pageable pageable);
    
}
