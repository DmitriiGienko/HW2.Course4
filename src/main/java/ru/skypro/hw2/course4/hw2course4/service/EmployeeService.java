package ru.skypro.hw2.course4.hw2course4.service;

import ru.skypro.hw2.course4.hw2course4.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    List<Employee> addEmployee(Employee employee);

    Employee updateEmployeeById(int id, String name,int salary);

    Employee getInfoEmployeeById(int id);

    void deleteEmployeeById(int id);

    List<Employee> getEmployeeWithSalaryMoreThan(int salary);


//    int getSumOfSalary();
//
//    Employee getMinSalaryEmployee();
//
//    Employee getMaxSalaryEmployee();
//
//    List<Employee> getEmployeeWithSalaryAboveAverage();


}
