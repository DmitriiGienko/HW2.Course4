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
//    @Override
//    public Employee updateEmployeeById(int id, String name, int salary) {
//        Employee emp = null;
//        List<Employee> list = employeeRepository.getAllEmployees();
//        for (Employee employee : list) {
//            if (employee.getId() == id) {
//                emp = employee;
//                employee.setName(name);
//                employee.setSalary(salary);
//            } else throw new EmployeeNotFoundException();
//        }
//        return emp;
//    }
//
//    @Override
//    public Employee getInfoEmployeeById(int id) {
//
//        Employee emp = null;
//        List<Employee> list = employeeRepository.getAllEmployees();
//        for (Employee employee : list) {
//            if (employee.getId() == id) {
//                emp = employee;
//            } else throw new EmployeeNotFoundException();
//        }
//        return emp;
//    }
//
//    @Override
//    public void deleteEmployeeById(int id) {
//        List<Employee> list = employeeRepository.getAllEmployees();
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getId() == id) {
//                list.remove(list.get(i));
//            } else throw new EmployeeNotFoundException();
//        }
//    }
//
//    @Override
//    public List<Employee> getEmployeeWithSalaryMoreThan(int higher) {
//        List<Employee> employeeList = getAllEmployees();
//        int sum = 0;
//        for (Employee employee : employeeList) {
//            sum += employee.getSalary();
//        }
//        int average = sum / employeeList.size();
//        return employeeList.stream()
//                .filter(employee -> employee.getSalary() > higher)
//                .toList();
//    }


}
