package ru.skypro.hw2.course4.hw2course4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.hw2.course4.hw2course4.exceptions.EmployeeNotFoundException;
import ru.skypro.hw2.course4.hw2course4.pojo.Employee;
import ru.skypro.hw2.course4.hw2course4.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()) {
            employeeList.add(employee);
        }
        return employeeList;
    }

    @Override
    public int getCount() {
        return (int) employeeRepository.count();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    //
    @Override
    public void updateEmployeeById(int id, String name, int salary) {
        if (employeeRepository.findById(id).isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        employeeRepository.updateEmployeeById(name, salary, id);
    }

    @Override
    public Employee getInfoEmployeeById(int id) {
        if (employeeRepository.findById(id).isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        return employeeRepository.findById(id).get();
    }
//
    @Override
    public void deleteEmployeeById(int id) {
        if (employeeRepository.findById(id).isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getEmployeeWithSalaryMoreThan(int higher) {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee :  employeeRepository.findEmployeeBySalaryGreaterThan(higher)) {
            employeeList.add(employee);
        }
        return employeeList;
    }


}
