package ru.skypro.hw2.course4.hw2course4.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "position")
@NoArgsConstructor
@Data
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String positionName;

}
