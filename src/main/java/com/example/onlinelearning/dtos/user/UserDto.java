package com.example.onlinelearning.dtos.user;

import com.example.onlinelearning.entities.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private  String userid;

    private List<Vehicle> vehicle;
    private String email;

    private String password;

    private String name;

    private List<String> roles = new ArrayList<>();
}
