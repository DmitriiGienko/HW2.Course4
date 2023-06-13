package ru.skypro.hw2.course4.hw2course4.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.hw2.course4.hw2course4.dto.EmployeeDTO;
import ru.skypro.hw2.course4.hw2course4.dto.EmployeeFullInfo;
import ru.skypro.hw2.course4.hw2course4.model.Employee;
import ru.skypro.hw2.course4.hw2course4.model.Position;
import ru.skypro.hw2.course4.hw2course4.service.EmployeeServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")


public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/showAllEmployees")
    public List<EmployeeDTO> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/fullInfo")
    public List<EmployeeFullInfo> getAllEmployeeInfo() {
        return employeeService.getEmployeesInfo();
    }

    @GetMapping("/showCount")
    public int getCount() {
        return employeeService.getCount();
    }

    @PostMapping("/addEmployees")
    public void addEmployee(@RequestParam String name,
                            @RequestParam int salary) {
        employeeService.addEmployee(new EmployeeDTO(name, salary));
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
    public EmployeeDTO getEmployeeById(@PathVariable int id) {
        return employeeService.getInfoEmployeeById(id);
    }

    @GetMapping("/salaryHigherThan")
    public List<EmployeeDTO> getEmployeeWithSalaryAboveAverage(@RequestParam int compareSalary) {
        return employeeService.getEmployeeWithSalaryMoreThan(compareSalary);
    }

    @GetMapping("/withHighestSalary")
    public List<EmployeeDTO> getEmployeesWithHighestSalary() {
        return employeeService.getEmployeeWithHighestSalary();
    }

    @GetMapping("/{id}/fullInfo")
    public EmployeeDTO getEmployeeFullInfo(@PathVariable int id) {
        return employeeService.getEmployeeFullInfo(id);
    }

    @GetMapping("/EmployeesPosition")
    public List<EmployeeDTO> getEmployeesForPosition(@RequestParam(required = false) String position) {
        return employeeService.getEmployeeByPosition(
                Optional.ofNullable(position)
                        .filter(p -> !p.isEmpty())
                        .orElse(null));

    }

    @GetMapping("/EmployeesPages")
    public List<EmployeeDTO> getEmployeesForPosition(@RequestParam(required = false, defaultValue = "0") int page) {
        return employeeService.getEmployeeByPage(page);
    }
}



