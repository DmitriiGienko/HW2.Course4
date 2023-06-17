package ru.skypro.hw2.course4.hw2course4.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Clob;

@Entity
@Table(name = "report")
@Data
@NoArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "CLOB")
    private byte[] bytes;

}
