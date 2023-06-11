package ru.skypro.hw2.course4.hw2course4.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.hw2.course4.hw2course4.model.Employee;
import ru.skypro.hw2.course4.hw2course4.repository.PagingEmployeeRepository;
import ru.skypro.hw2.course4.hw2course4.service.EmployeeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/employees")


public class EmployeeController {

    private final EmployeeServiceImpl employeeService;
    private final PagingEmployeeRepository pagingEmployeeRepository;


    public EmployeeController(EmployeeServiceImpl employeeService, PagingEmployeeRepository pagingEmployeeRepository) {
        this.employeeService = employeeService;
        this.pagingEmployeeRepository = pagingEmployeeRepository;
    }

    @GetMapping("/showAllEmployees")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/addEmployee")
    public void addEmployee(@RequestParam String name,
                            @RequestParam int salary) {
        employeeService.addEmployee(new Employee(name, salary));
    }

    @PutMapping("/employees/{id}")
    public void updateEmployee(@RequestParam int id,
                               @RequestParam String newName,
                               @RequestParam int newSalary) {
        employeeService.updateEmployeeById(id, newName, newSalary);

    }

    @DeleteMapping("/deleteEmployees/{id}")
    public void deleteEmployee(@RequestParam int id) {
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/employeesById/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getInfoEmployeeById(id);
    }

    @GetMapping("/employeesByName/{name}")
    public Employee getEmployeeById(@PathVariable String name) {
        return employeeService.getEmployeeByName(name);
    }

    @GetMapping("/salaryHigherThan")
    public List<Employee> getEmployeeWithSalaryAboveAverage(@RequestParam int compareSalary) {
        return employeeService.getEmployeeWithSalaryMoreThan(compareSalary);
    }

//    @GetMapping("/paging/{page}/{size}")
//    public List<Employee> getEmployeeWishPaging(@PathVariable int page,
//                                                @PathVariable int size) {
//        return employeeService.getEmployeeWishPaging(page, size);
    }



