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
        List<Employee> list = employeeRepository.getAllEmployees();
        for (Employee employee : list) {
            if (employee.getId() == id) {
                emp = employee;
                employee.setName(name);
                employee.setSalary(salary);
            }
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
            }
        }
        return emp;
    }

    @Override
    public void deleteEmployeeById(int id) {
        List<Employee> list = employeeRepository.getAllEmployees();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(list.get(i));
            }
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

}
