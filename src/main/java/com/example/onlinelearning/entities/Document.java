package com.example.onlinelearning.entities;/*
Created on 9/29/2023  2:05 PM 2023

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
@Table(name="document")
public class Document implements Serializable{

    // luu tru cac tai lieu nhu pdf, pptx, docx, .rar, .zip
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "file_path")
    private String file_path;

    @Column(name = "title")
    private String description;

    @Column(name = "create_at")
    private Date create_at= new Date(new java.util.Date().getTime());

    @Column(name = "update_at")
    private Date update_at= new Date(new java.util.Date().getTime());


    // moi khoa hoc se gom nhieu video
    @ManyToOne
    @JoinColumn(name = "video_id")
    private Video video;
}
