package ru.skypro.hw2.course4.hw2course4.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skypro.hw2.course4.hw2course4.pojo.Employee;
import ru.skypro.hw2.course4.hw2course4.service.EmployeeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/employee")


public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/allEmployees")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/")
    public void addEmployee(@RequestParam Employee employee) {
        employeeService.addEmployee(employee);
    }


//    @GetMapping("/salary/max")
//    public Employee getMaxSalaryEmployee() {
//        return employeeService.getMaxSalaryEmployee();
//    }
//
//    @GetMapping("/salary/min")
//    public Employee getMinSalaryEmployee() {
//        return employeeService.getMinSalaryEmployee();
//    }
//
//    @GetMapping("/salary/sum")
//    public int getSumOfSalary() {
//        return employeeService.getSumOfSalary();
//    }
//
//    @GetMapping("/high-salary")
//    public List<Employee> getEmployeeWithSalaryAboveAverage() {
//        return employeeService.getEmployeeWithSalaryAboveAverage();
//    }
}
