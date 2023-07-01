package ru.skypro.hw2.course4.hw2course4.security;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "auth_user")
@Data
public class AuthUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @JoinColumn(name = "user_id")
    @OneToMany(fetch = FetchType.EAGER)
    private List<Authority> authorityList;
}
