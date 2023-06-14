package ru.skypro.hw2.course4.hw2course4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeFullInfo {
    private String name;
    private int salary;
    private String positionName;
}
