package com.example.bus_reservation_app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "adminTable")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "emailID")
    private String emailID;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
    @Column(name = "createAt")
    private Long createAt;

}
