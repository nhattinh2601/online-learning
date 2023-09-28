package com.example.onlinelearning.dtos.vehicle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {

    private String vehicleid;
    private String name;

    //private List<String> giaDichVus = new ArrayList<>();
}
