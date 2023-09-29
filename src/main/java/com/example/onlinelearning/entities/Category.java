package com.example.onlinelearning.entities;/*
Created on 9/29/2023  9:58 AM 2023

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
@Table(name="category")

public class Category  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "parent_category_id")
    private int parent_category_id;

    @Column(name = "create_at")
    private Date create_at= new Date(new java.util.Date().getTime());

    @Column(name = "update_at")
    private Date update_at= new Date(new java.util.Date().getTime());

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private Set<Course> courses;

}
