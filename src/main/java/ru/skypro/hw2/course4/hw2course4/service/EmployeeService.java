package ru.skypro.hw2.course4.hw2course4.service;

import ru.skypro.hw2.course4.hw2course4.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    int getCount();


    void addEmployee(Employee employee);
//
    void updateEmployeeById(int id, String name, int salary);
//
    Employee getInfoEmployeeById(int id);
//
    void deleteEmployeeById(int id);
//
    List<Employee> getEmployeeWithSalaryMoreThan(int salary);


}
