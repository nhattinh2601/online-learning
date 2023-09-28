package com.example.onlinelearning.repositories;

import com.example.onlinelearning.entities.Transactions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transactions,String> {

    Page<Transactions> findByIdContainingAllIgnoreCase(String search,  Pageable pageable);

}
