package ru.skypro.hw2.course4.hw2course4.service;

import ru.skypro.hw2.course4.hw2course4.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    int getSumOfSalary();

    Employee getMinSalaryEmployee();

    Employee getMaxSalaryEmployee();

    List<Employee> getEmployeeWithSalaryAboveAverage();

     void addEmployee(Employee employee);



}
