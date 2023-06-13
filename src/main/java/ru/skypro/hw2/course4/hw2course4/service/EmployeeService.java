package ru.skypro.hw2.course4.hw2course4.service;

import ru.skypro.hw2.course4.hw2course4.dto.EmployeeDTO;
import ru.skypro.hw2.course4.hw2course4.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();

    void addEmployee(EmployeeDTO employee);

    void updateEmployeeById(int id, String name, int salary);

    EmployeeDTO getInfoEmployeeById(int id);

    void deleteEmployeeById(int id);

    List<EmployeeDTO> getEmployeeWithSalaryMoreThan(int salary);


}
