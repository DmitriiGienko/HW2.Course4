package ru.skypro.hw2.course4.hw2course4.service;

import org.springframework.stereotype.Service;
import ru.skypro.hw2.course4.hw2course4.dto.EmployeeDTO;
import ru.skypro.hw2.course4.hw2course4.exceptions.EmployeeNotFoundException;
import ru.skypro.hw2.course4.hw2course4.model.Employee;
import ru.skypro.hw2.course4.hw2course4.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()) {
            employeeList.add(employee);
        }
        return employeeList.stream()
                .map(EmployeeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addEmployee(EmployeeDTO employee) {
        employeeRepository.save(EmployeeMapper.toEmployee(employee));


    }

    @Override
    public void updateEmployeeById(int id, String name, int salary) {
        Employee employee = employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
        employee.setName(name);
        employee.setSalary(salary);
        employeeRepository.save(employee);
    }

    @Override
    public EmployeeDTO getInfoEmployeeById(int id) {

        return employeeRepository.findById(id)
                .map(EmployeeMapper::toDto)
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public void deleteEmployeeById(int id) {
        if (employeeRepository.findById(id).isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDTO> getEmployeeWithSalaryMoreThan(int higher) {
        return employeeRepository.findEmployeeBySalaryGreaterThan(higher).stream()
                .map(EmployeeMapper::toDto)
                .collect(Collectors.toList());
    }


}
