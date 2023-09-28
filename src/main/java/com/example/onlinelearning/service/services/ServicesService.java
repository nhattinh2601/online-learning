package com.example.onlinelearning.service.services;


import com.example.onlinelearning.dtos.services.ServiceDto;
import com.example.onlinelearning.entities.Services;
import org.springframework.data.domain.Page;

import java.util.List;


public interface ServicesService {
    Page<Services> filter(String search, int page, int size, String sort, String column);

    public Services findById(String id);

    List<Services> findAll();

    Services create(ServiceDto dto);
    
    Services update(String id, ServiceDto dto);
    public void deleteById(String id);

}
