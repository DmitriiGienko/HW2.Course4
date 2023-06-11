package ru.skypro.hw2.course4.hw2course4.service;

import ru.skypro.hw2.course4.hw2course4.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void addEmployee(Employee employee);

    Employee updateEmployeeById(int id, String name, int salary);

    Employee getInfoEmployeeById(Integer id);

    void deleteEmployeeById(Integer id);

    List<Employee> getEmployeeWithSalaryMoreThan(int salary);

    Employee getEmployeeByName(String name);

    int getCount();

    List<Employee> getEmployeeWishPaging(int page,int size);


}
