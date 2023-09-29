package com.example.onlinelearning.entities;

import java.io.Serializable;


import javax.persistence.*;

import lombok.*;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "active")
    private boolean active;

    @Column(name = "password")
    private String password;

    // dung de mo ta nguoi dung khi ho tro thanh giang vien
    @Column(name = "description", length = 10000 )
    private String description;

    //thong tin chuyen khoan khi tro thanh giang vien
    @Column(name = "bank_name")
    private String bank_name;

    @Column(name = "account_number")
    private String account_number;

    @Column(name = "account_name")
    private String account_name;

    @Column(name = "create_at")
    private Date create_at= new Date(new java.util.Date().getTime());

    @Column(name = "update_at")
    private Date update_at= new Date(new java.util.Date().getTime());

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    // moi nguoi dung co the giang day nhieu khoa hoc khac nhau
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Course> courses;

    //review khoa hoc, moi nguoi chi review 1 khoa hoc/1 lan
    @OneToOne(mappedBy = "user")
    private Review review;

    //review khoa hoc, moi nguoi chi danh gia sao 1 khoa hoc/1 lan
    @OneToOne(mappedBy = "user")
    private Rating rating;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<CourseRegister> registers;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Cart> carts;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Orders> orders;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Comment> comments;

}
