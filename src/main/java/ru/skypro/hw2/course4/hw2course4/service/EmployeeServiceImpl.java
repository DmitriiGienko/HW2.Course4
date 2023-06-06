package ru.skypro.hw2.course4.hw2course4.service;

import org.springframework.stereotype.Service;
import ru.skypro.hw2.course4.hw2course4.exceptions.EmployeeExceptionHandler;
import ru.skypro.hw2.course4.hw2course4.exceptions.EmployeeNotFoundException;
import ru.skypro.hw2.course4.hw2course4.pojo.Employee;
import ru.skypro.hw2.course4.hw2course4.repository.EmployeeRepositoryImpl;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepositoryImpl employeeRepository;

    public EmployeeServiceImpl(EmployeeRepositoryImpl employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();


    }

    @Override
    public List<Employee> addEmployee(Employee employee) {
        List<Employee> newEmp = employeeRepository.getAllEmployees();
        newEmp.add(employee);
        return newEmp;


    }

    @Override
    public Employee updateEmployeeById(int id, String name, int salary) {
        Employee emp = null;
        List<Employee> list = employeeRepository.getAllEmployees();
        for (Employee employee : list) {
            if (employee.getId() == id) {
                emp = employee;
                employee.setName(name);
                employee.setSalary(salary);
            } else throw new EmployeeNotFoundException();
        }
        return emp;
    }

    @Override
    public Employee getInfoEmployeeById(int id) {

        Employee emp = null;
        List<Employee> list = employeeRepository.getAllEmployees();
        for (Employee employee : list) {
            if (employee.getId() == id) {
                emp = employee;
            } else throw new EmployeeNotFoundException();
        }
        return emp;
    }

    @Override
    public void deleteEmployeeById(int id) {
        List<Employee> list = employeeRepository.getAllEmployees();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(list.get(i));
            } else throw new EmployeeNotFoundException();
        }
    }

    @Override
    public List<Employee> getEmployeeWithSalaryMoreThan(int higher) {
        List<Employee> employeeList = getAllEmployees();
        int sum = 0;
        for (Employee employee : employeeList) {
            sum += employee.getSalary();
        }
        int average = sum / employeeList.size();
        return employeeList.stream()
                .filter(employee -> employee.getSalary() > higher)
                .toList();
    }


}
