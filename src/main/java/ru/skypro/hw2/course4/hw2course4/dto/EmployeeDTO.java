package ru.skypro.hw2.course4.hw2course4.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO {
    private int id;
    private String name;
    private int salary;

    public EmployeeDTO(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public EmployeeDTO(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }


}
