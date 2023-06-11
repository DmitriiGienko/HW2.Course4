package ru.skypro.hw2.course4.hw2course4.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int salary;


    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}
