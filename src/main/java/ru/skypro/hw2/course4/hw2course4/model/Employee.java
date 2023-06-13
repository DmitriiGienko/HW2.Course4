package ru.skypro.hw2.course4.hw2course4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.invoke.TypeDescriptor;

@Data
@NoArgsConstructor
@Entity

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int salary;
    @ManyToOne()
    @JoinColumn(name = "position_id")
    private Position position;


    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

}
