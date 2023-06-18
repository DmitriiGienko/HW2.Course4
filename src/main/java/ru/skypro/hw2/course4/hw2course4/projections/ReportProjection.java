package ru.skypro.hw2.course4.hw2course4.projections;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ReportProjection {
//    Название отдела.
//    Количество сотрудников.
//    Максимальная зарплата.
//    Минимальная зарплата.
//    Средняя зарплата.
    private String namePosition;
    private double countOfEmployee;
    private int maxSalary;
    private int minSalary;
    private double averageSalary;

    public ReportProjection(String namePosition, double countOfEmployee, int maxSalary, int minSalary, double averageSalary) {
        this.namePosition = namePosition;
        this.countOfEmployee = countOfEmployee;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.averageSalary = averageSalary;
    }
}
