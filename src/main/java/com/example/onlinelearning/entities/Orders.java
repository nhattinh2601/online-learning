package com.example.onlinelearning.entities;/*
Created on 9/29/2023  5:14 PM 2023

@author: tinh2

ProjectName: online-learning
*/

import java.io.Serializable;

import java.util.Date;


import javax.persistence.*;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "payment_price")
    private float payment_price;

    @Column(name = "status")
    private int status;

    @Column(name = "create_at")
    private Date create_at= new Date(new java.util.Date().getTime());

    @Column(name = "update_at")
    private Date update_at= new Date(new java.util.Date().getTime());

}
