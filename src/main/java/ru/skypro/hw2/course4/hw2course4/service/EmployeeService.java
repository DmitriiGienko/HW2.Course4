package ru.skypro.hw2.course4.hw2course4.service;

import ru.skypro.hw2.course4.hw2course4.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void addEmployee(Employee employee);

    Employee updateEmployeeById(int id);

    Employee getEmployeeById(int id);

    void deleteEmployeeById(int id);

    List<Employee> getEmployeeWithSalaryMoreThan();


//    int getSumOfSalary();
//
//    Employee getMinSalaryEmployee();
//
//    Employee getMaxSalaryEmployee();
//
//    List<Employee> getEmployeeWithSalaryAboveAverage();


}
