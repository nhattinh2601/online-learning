package com.example.onlinelearning.entities;/*
Created on 9/29/2023  2:46 PM 2023

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
@Table(name="rating")
public class Rating implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // danh gia sao tu 1-5
    @Column(name = "rating")
    private int rating ;

    @Column(name = "create_at")
    private Date create_at= new Date(new java.util.Date().getTime());

    @Column(name = "update_at")
    private Date update_at= new Date(new java.util.Date().getTime());

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}