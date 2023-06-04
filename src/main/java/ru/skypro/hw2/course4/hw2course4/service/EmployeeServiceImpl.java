package ru.skypro.hw2.course4.hw2course4.service;

import org.springframework.stereotype.Service;
import ru.skypro.hw2.course4.hw2course4.pojo.Employee;
import ru.skypro.hw2.course4.hw2course4.repository.EmployeeRepositoryImpl;

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
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);

    }

    @Override
    public Employee updateEmployeeById(int id) {
        return null;
    }

    @Override
    public Employee getEmployeeById(int id) {
        return null;
    }

    @Override
    public void deleteEmployeeById(int id) {

    }

    @Override
    public List<Employee> getEmployeeWithSalaryMoreThan() {
        return null;
    }

    //    @Override
//    public int getSumOfSalary() {
//
//        int sum = 0;
//        for (Employee employee : getAllEmployees()) {
//            sum += employee.getSalary();
//        }
//        return sum;
//    }
//
//    @Override
//    public Employee getMinSalaryEmployee() {
//        List<Employee> sortedList = getAllEmployees().stream()
//                .sorted(Comparator.comparing(Employee::getSalary))
//                .toList();
//        return sortedList.get(0);
//    }
//
//    @Override
//    public Employee getMaxSalaryEmployee() {
//        List<Employee> sortedList = getAllEmployees().stream()
//                .sorted(Comparator.comparing(Employee::getSalary))
//                .toList();
//        return sortedList.get(sortedList.size() - 1);
//    }
//
//    @Override
//    public List<Employee> getEmployeeWithSalaryAboveAverage() {
//        List<Employee> employeeList = getAllEmployees();
//        int sum = 0;
//        for (Employee employee : employeeList) {
//            sum += employee.getSalary();
//        }
//        int average = sum / employeeList.size();
//        return employeeList.stream()
//                .filter(employee -> employee.getSalary() > average)
//                .toList();
//    }
}
