package ru.skypro.hw2.course4.hw2course4.projections;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReportProjection {
//    Название отдела.
//    Количество сотрудников.
//    Максимальная зарплата.
//    Минимальная зарплата.
//    Средняя зарплата.
    private String namePosition;
    private int countOfEmployee;
    private int maxSalary;
    private int minSalary;
    private double averageSalary;
}
