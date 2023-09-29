package com.example.onlinelearning.entities;/*
Created on 9/29/2023  1:55 PM 2023

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
@Table(name="video")
public class Video implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "file_path")
    private String file_path;

    @Column(name = "image")
    private String image;

    @Column(name = "views")
    private int views;

    @Column(name = "hours")
    private int hours;

    @Column(name = "minutes")
    private int minutes;

    @Column(name = "seconds")
    private int seconds;

    @Column(name = "create_at")
    private Date create_at= new Date(new java.util.Date().getTime());

    @Column(name = "update_at")
    private Date update_at= new Date(new java.util.Date().getTime());

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "video",cascade = CascadeType.ALL)
    private Set<Document> documents;

    @OneToMany(mappedBy = "video",cascade = CascadeType.ALL)
    private Set<Comment> comments;
}
