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

    @GetMapping("/all")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/salary/max")
    public Employee getMaxSalaryEmployee() {
        return employeeService.getMaxSalaryEmployee();
    }

    @GetMapping("/salary/min")
    public Employee getMinSalaryEmployee() {
        return employeeService.getMinSalaryEmployee();
    }

    @GetMapping("/salary/sum")
    public int getSumOfSalary() {
        return employeeService.getSumOfSalary();
    }

    @GetMapping("/high-salary")
    public List<Employee> getEmployeeWithSalaryAboveAverage() {
        return employeeService.getEmployeeWithSalaryAboveAverage();
    }

    @GetMapping("/{name}")
    public int getEmployeeWithName(@PathVariable String name) {
//        return employeeService.getEmployeeWithSalaryAboveAverage();
        int sal = 0;
        List<Employee> employeeList = employeeService.getAllEmployees();
        for (Employee employee : employeeList) {
            if (employee.getName().equals(name)) {
                sal = employee.getSalary();
               break;
            } else sal = 0;
        }
        return sal;
    }

    @GetMapping("/salary/higer")
    public int getEmpWithSalaryMoreThan(@RequestParam("compSal") Integer compSal) {
        List<Employee> employeeList = employeeService.getAllEmployees();
        int sum = 0;
        for (Employee employee : employeeList) {
            if (employee.getSalary() > compSal) {
                sum++;
            }
        }
        return sum;
    }
}
