package ru.skypro.hw2.course4.hw2course4.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "position")
@Getter
@Setter
@NoArgsConstructor
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String positionName;

    public Position(String positionName) {
        this.positionName = positionName;
    }

    @Override
    public String toString() {
        return "positionName= " + positionName;
    }
}
