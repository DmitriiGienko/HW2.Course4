package ru.skypro.hw2.course4.hw2course4.service;

import io.micrometer.common.lang.Nullable;
import ru.skypro.hw2.course4.hw2course4.dto.EmployeeDTO;
import ru.skypro.hw2.course4.hw2course4.dto.EmployeeFullInfo;
import ru.skypro.hw2.course4.hw2course4.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();

    int getCount();


    void addEmployee(EmployeeDTO employee);


    void updateEmployeeById(int id, String name, int salary);


    EmployeeDTO getInfoEmployeeById(int id);


    void deleteEmployeeById(int id);


    List<EmployeeDTO> getEmployeeWithSalaryMoreThan(int salary);

    List<EmployeeDTO> getEmployeeWithHighestSalary();

    List<EmployeeFullInfo> getEmployeesInfo();

    EmployeeDTO getEmployeeFullInfo(int id);

   List<EmployeeDTO> getEmployeeByPosition(String position);

    List<EmployeeDTO> getEmployeeByPage(int page);



}
