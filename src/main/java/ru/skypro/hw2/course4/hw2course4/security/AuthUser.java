package ru.skypro.hw2.course4.hw2course4.security;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "auth_user")
@Data
@NoArgsConstructor
public class AuthUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String userName;

    private String password;

    private boolean isEnabled;

    @JoinColumn(name = "user_id")
    @OneToMany(fetch = FetchType.EAGER)
    private List<Authority> authorityList;
}
