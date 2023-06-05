package ru.skypro.hw2.course4.hw2course4.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skypro.hw2.course4.hw2course4.pojo.Employee;
import ru.skypro.hw2.course4.hw2course4.service.EmployeeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/employees")


public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/allEmployees")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestParam(required = false) String name,
                            @RequestParam(required = false) int salary) {
        employeeService.addEmployee(new Employee(name, salary));
    }

    @PutMapping("/employees/{id}")
    public void updateEmployee(@RequestParam int id,
                               @RequestParam String newName,
                               @RequestParam int newSalary) {
        employeeService.updateEmployeeById(id, newName, newSalary);

    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@RequestParam int id) {
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/employees/{id}")
    public void getEmployeeById(@PathVariable int id) {
        employeeService.getInfoEmployeeById(id);
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
