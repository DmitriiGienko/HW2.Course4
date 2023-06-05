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
    public List<Employee> addEmployee(Employee employee) {
        List<Employee> newEmp = employeeRepository.getAllEmployees();
        newEmp.add(employee);
        return newEmp;


    }

    @Override
    public Employee updateEmployeeById(int id, String name, int salary) {
        Employee emp = null;
        for (int i = 0; i < employeeRepository.getAllEmployees().size(); i++) {
            if (employeeRepository.getAllEmployees().get(i).getId() == id) {
                emp = employeeRepository.getAllEmployees().get(i);
                employeeRepository.getAllEmployees().get(i).setName(name);
                employeeRepository.getAllEmployees().get(i).setSalary(salary);
            }
        }
        return emp;
    }

    @Override
    public Employee getInfoEmployeeById(int id) {
        Employee employee = getAllEmployees().stream()
                .filter(employee1 -> employee1.getId() == id)
                .findAny().orElse(null);

        return employee;
    }

    @Override
    public void deleteEmployeeById(int id) {
        for (int i = 0; i < employeeRepository.getAllEmployees().size(); i++) {
            if (employeeRepository.getAllEmployees().get(i).getId() == id) {
                employeeRepository.getAllEmployees().remove(employeeRepository.getAllEmployees().get(i));
            }
        }

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
