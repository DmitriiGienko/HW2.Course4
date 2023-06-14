package ru.skypro.hw2.course4.hw2course4.dto;

import lombok.*;
import ru.skypro.hw2.course4.hw2course4.model.Position;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO {
    private int id;
    private String name;
    private int salary;
    private Position position;

    public EmployeeDTO(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public EmployeeDTO(String name, int salary, Position position) {
        this.name = name;
        this.salary = salary;
        this.position = position;
    }


}
