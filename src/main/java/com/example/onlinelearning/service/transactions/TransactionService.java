package com.example.onlinelearning.service.transactions;


import com.example.onlinelearning.dtos.services.ServiceDto;

import com.example.onlinelearning.dtos.transactions.TransactionDto;
import com.example.onlinelearning.dtos.user.UserDto;
import com.example.onlinelearning.dtos.vehicle.VehicleDto;
import com.example.onlinelearning.entities.Transactions;
import org.springframework.data.domain.Page;

import java.security.Principal;
import java.util.List;

public interface TransactionService {
    Page<Transactions> filter(String search, int page, int size, String sort, String column);


    public List<Transactions> findAll();

    public TransactionDto create(TransactionDto dto, Principal principal, String vehicleId, String userId, String serviceId) ;

    public Transactions update(String id, TransactionDto dto);
    Transactions findById(String id);

    void deleteById(String id);

    public Transactions changeStatus(String id);
}
