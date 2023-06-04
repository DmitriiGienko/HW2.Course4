package ru.skypro.hw2.course4.hw2course4.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.hw2.course4.hw2course4.pojo.Employee;
import ru.skypro.hw2.course4.hw2course4.service.EmployeeServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/employee")

public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
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

    @GetMapping("count/{division}")
    public String getEmployeeByDivision(@PathVariable String division) throws SQLException {
        throw new SQLException();
//        return division;
    }

//    @GetMapping("/count")
//    public Employee getEmployeeCountByNameAndSalaryHigher(@RequestParam(value = "name", required = true) String name,
//                                                          @RequestParam(value = "salary", required = true) int lowBorder) {
//        return new Employee(name, lowBorder + 1000);
//    }

    @PostMapping("/create")
    public void createEmployee(@RequestBody Employee employee) {

        System.out.println(employee.getName() + " создан");
        employeeService.addEmployee(employee);
        employeeService.getAllEmployees().forEach(a-> System.out.println(a));

    }


}
