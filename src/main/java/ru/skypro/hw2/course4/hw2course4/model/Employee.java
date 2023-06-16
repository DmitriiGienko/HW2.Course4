package ru.skypro.hw2.course4.hw2course4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.lang.invoke.TypeDescriptor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employee")
@Accessors(chain = true)


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

    public Employee(String name, int salary, Position position) {
        this.name = name;
        this.salary = salary;
        this.position = position;
    }
}
