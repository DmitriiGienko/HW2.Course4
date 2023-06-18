package ru.skypro.hw2.course4.hw2course4.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.file.Path;
import java.sql.Clob;

@Entity
@Table(name = "reportWithPath")
@Data
@NoArgsConstructor

public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob
    @Column(name = "info", columnDefinition = "text")
    private String filePath;

    public Report(String filePath) {
        this.filePath = filePath;
    }
}
