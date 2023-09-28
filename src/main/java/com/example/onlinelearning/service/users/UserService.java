package com.example.onlinelearning.service.users;

import com.example.onlinelearning.dtos.vehicle.VehicleDto;
import com.example.onlinelearning.dtos.user.SigupDto;
import com.example.onlinelearning.dtos.user.UpdateUserDto;
import com.example.onlinelearning.dtos.user.UserDto;
import com.example.onlinelearning.entities.User;
import org.springframework.data.domain.Page;

import java.security.Principal;
import java.util.List;

public interface UserService {

    Page<User> filter(String search,
                      int page, int size, String sort, String column);

    List<User> findAll();

    User getUser(String id);

    User findById(String id);

    void deleteById(String id);
    public User getUserByEmail(String email);

    User create(SigupDto dto, Principal principal);



    User update(String id, UpdateUserDto dto, Principal principal);


    public UserDto addVehicle(String userId, String vehicleId);
}
