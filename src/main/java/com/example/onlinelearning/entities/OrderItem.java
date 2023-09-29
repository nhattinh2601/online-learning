package com.example.onlinelearning.entities;/*
Created on 9/29/2023  5:15 PM 2023

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
@Table(name="order_item")
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @Column(name = "create_at")
    private Date create_at= new Date(new java.util.Date().getTime());

    @Column(name = "update_at")
    private Date update_at= new Date(new java.util.Date().getTime());


}
