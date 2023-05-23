package ru.skypro.hw2.course4.hw2course4.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.hw2.course4.hw2course4.pojo.Employee;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final List<Employee> employeeList = List.of(
            new Employee("Катя", 90_000),
            new Employee("Дима", 102_000),
            new Employee("Олег", 80_000),
            new Employee("Вика", 165_000));


    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}
