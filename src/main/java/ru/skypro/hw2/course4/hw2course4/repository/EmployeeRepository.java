package ru.skypro.hw2.course4.hw2course4.repository;

import ru.skypro.hw2.course4.hw2course4.pojo.Employee;

import java.util.List;

public interface EmployeeRepository {

     List<Employee> getAllEmployees();

     void  addEmployee(Employee employee);
}
