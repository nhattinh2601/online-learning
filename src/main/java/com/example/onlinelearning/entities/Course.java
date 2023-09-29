package com.example.onlinelearning.entities;/*
Created on 9/29/2023  1:34 PM 2023

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
@Table(name="course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "price")
    private float price;

    @Column(name = "promotional_price")
    private float promotional_price;

    @Column(name = "sold")
    private float sold;

    @Column(name = "description")
    private String description;

    @Column(name = "active")
    private boolean active;

    @Column(name = "rating")
    private float rating;

    @Column(name = "image")
    private String image;

    @Column(name = "create_at")
    private Date create_at= new Date(new java.util.Date().getTime());

    @Column(name = "update_at")
    private Date update_at= new Date(new java.util.Date().getTime());

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // moi khoa hoc tuong ung voi 1 nguoi giang day
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User user;

    // moi khoa hoc se gom nhieu video
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private Set<Video> videos;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private Set<CourseRegister> registers;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private Set<Cart> carts;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems;
}
