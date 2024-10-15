package com.micro.userservice.UserService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "micro_user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @Column(name = "id")
    private String userId;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "email",nullable = true)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "about")
    private String about;

    @Transient
    private List<Rating> userRatings = new ArrayList<>();
}
