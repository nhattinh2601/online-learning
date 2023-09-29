package com.example.onlinelearning.entities;/*
Created on 9/28/2023  5:49 PM 2023

@author: tinh2

ProjectName: online-learning
*/
import java.io.Serializable;

import java.util.Date;
import java.util.Set;


import javax.persistence.*;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="role")
public class Role implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role_name")
    private String role_name;

    @Column(name = "create_at")
    private Date create_at= new Date(new java.util.Date().getTime());

    @Column(name = "update_at")
    private Date update_at= new Date(new java.util.Date().getTime());

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    private Set<User> users;
}
