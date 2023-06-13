package ru.skypro.hw2.course4.hw2course4.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO {
    private int id;
    private String name;
    private int salary;
    private String positionName;

    public EmployeeDTO(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public EmployeeDTO(String name, int salary, String positionName) {
        this.name = name;
        this.salary = salary;
        this.positionName = positionName;
    }


}
