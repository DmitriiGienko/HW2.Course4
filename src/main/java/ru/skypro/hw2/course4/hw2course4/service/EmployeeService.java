package ru.skypro.hw2.course4.hw2course4.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.hw2.course4.hw2course4.dto.EmployeeDTO;
import ru.skypro.hw2.course4.hw2course4.projections.EmployeeFullInfo;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();

    void addEmployee(EmployeeDTO employee);

    void updateEmployeeById(int id, String name, int salary);

    EmployeeDTO getInfoEmployeeById(int id);

    void deleteEmployeeById(int id);

    List<EmployeeDTO> getEmployeeWithSalaryMoreThan(int salary);

    List<EmployeeDTO> getEmployeeWithMaxSalary();

    List<EmployeeFullInfo> getEmployeeFullInfo();

    EmployeeDTO getFullInfoById(int id);

    List<EmployeeDTO> getEmployeeByPage(int page);

    List<EmployeeDTO> getEmployeesOnPosition(String positionName);

    void uploadEmployee(MultipartFile file) throws IOException;
}
