package ru.skypro.hw2.course4.hw2course4.security;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "role")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String role;
}
