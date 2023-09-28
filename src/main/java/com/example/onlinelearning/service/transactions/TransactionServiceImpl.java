package com.example.onlinelearning.service.transactions;

import com.example.onlinelearning.dtos.services.ServiceDto;

import com.example.onlinelearning.dtos.transactions.TransactionDto;
import com.example.onlinelearning.dtos.user.SigupDto;
import com.example.onlinelearning.dtos.user.UserDto;
import com.example.onlinelearning.dtos.vehicle.VehicleDto;
import com.example.onlinelearning.entities.Services;
import com.example.onlinelearning.entities.Transactions;
import com.example.onlinelearning.entities.User;
import com.example.onlinelearning.entities.Vehicle;
import com.example.onlinelearning.exceptions.InvalidException;
import com.example.onlinelearning.exceptions.NotFoundException;
import com.example.onlinelearning.repositories.ServicesRepository;
import com.example.onlinelearning.repositories.TransactionRepository;
import com.example.onlinelearning.repositories.UserRepository;
import com.example.onlinelearning.repositories.VehicleRepository;
import com.example.onlinelearning.utils.EnumRole;
import com.example.onlinelearning.utils.PageUtils;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {
    public final TransactionRepository loaiThuCungRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Page<Transactions> filter(String search, int page, int size, String sort, String column) {
        Pageable pageable = PageUtils.createPageable(page, size, sort, column);
        return loaiThuCungRepository.findByIdContainingAllIgnoreCase(search, pageable);
    }

    @Override
    public List<Transactions> findAll() {
        return loaiThuCungRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        loaiThuCungRepository.deleteById(id);
    }

    @Override
    public Transactions findById(String id) {
        return loaiThuCungRepository.findById(id)
            .orElseThrow(()-> new NotFoundException(String.format("User with id %s does not exist",id)));
    }


    @Override
    public TransactionDto create(TransactionDto dto, Principal principal, String vehicleId, String userId, String serviceId) {
        Transactions transaction = new Transactions();

        // kt khóa ngoại tham chiếu có đúng hay không - bảng vehicle
        if (transaction.getVehicle() != null && transaction.getVehicle().stream().anyMatch(r -> r != null && r.getId().equals(vehicleId))) {
            throw new IllegalArgumentException("Reservation with ID " + vehicleId + " already exists for user with ID " );
        }

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new NotFoundException("Transaction not found with id: " + vehicleId));
//        tạo dữ liệu trong bảng vehicle
        vehicle = vehicleRepository.save(vehicle);
        if (transaction.getVehicle() == null) {
            transaction.setVehicle(new ArrayList<>());
        }
        transaction.getVehicle().add(vehicle);

        // kt khóa ngoại tham chiếu có đúng hay không - bảng user
        if (transaction.getUsers() != null && transaction.getUsers().stream().anyMatch(r -> r != null && r.getId().equals(userId))) {
            throw new IllegalArgumentException("Reservation with ID " + userId + " already exists for user with ID " );
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Transaction not found with id: " + userId));
//        tạo dữ liệu trong bảng vehicle
        user = userRepository.save(user);
        if (transaction.getUsers() == null) {
            transaction.setUsers(new ArrayList<>());
        }
        transaction.getUsers().add(user);


        // kt khóa ngoại tham chiếu có đúng hay không - bảng user
        if (transaction.getUsers() != null && transaction.getUsers().stream().anyMatch(r -> r != null && r.getId().equals(serviceId))) {
            throw new IllegalArgumentException("Reservation with ID " + serviceId + " already exists for user with ID " );
        }

        Services services = servicesRepository.findById(serviceId)
                .orElseThrow(() -> new NotFoundException("Transaction not found with id: " + serviceId));
//        tạo dữ liệu trong bảng vehicle
        services = servicesRepository.save(services);
        if (transaction.getServices() == null) {
            transaction.setServices(new ArrayList<>());
        }
        transaction.getServices().add(services);

//
        transaction.setAmount(dto.getAmount());
        transaction.setDateTransaction(dto.getDateTransaction());

        loaiThuCungRepository.save(transaction);
        return modelMapper.map(transaction, TransactionDto.class);
    }

    @Override
    public Transactions update(String id, TransactionDto dto) {
        Optional<Transactions> loaiThuCung=loaiThuCungRepository.findById(id);

        loaiThuCung.get().setAmount(dto.getAmount());
        loaiThuCung.get().setDateTransaction(dto.getDateTransaction());
        return loaiThuCungRepository.save(loaiThuCung.get());
    }


    @Override
    public Transactions changeStatus(String id) {
        Optional<Transactions> loaiThuCung = loaiThuCungRepository.findById(id);
        if(loaiThuCung==null)
            throw new NotFoundException(String.format("Mã loại thú Cưng %s không tồn tại", loaiThuCung));
        loaiThuCung.get().setTrangThai(!loaiThuCung.get().isTrangThai());
        return loaiThuCungRepository.save(loaiThuCung.get());
    }
}
