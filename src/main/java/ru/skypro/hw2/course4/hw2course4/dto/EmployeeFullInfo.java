package ru.skypro.hw2.course4.hw2course4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class EmployeeFullInfo {
    private String name;
    private int salary;
    private String positionName;

    public EmployeeFullInfo(String name, int salary, String positionName) {
        this.name = name;
        this.salary = salary;
        this.positionName = positionName;
    }
}
