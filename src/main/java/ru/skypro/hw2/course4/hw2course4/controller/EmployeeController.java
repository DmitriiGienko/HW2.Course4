package ru.skypro.hw2.course4.hw2course4.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.hw2.course4.hw2course4.dto.EmployeeDTO;
import ru.skypro.hw2.course4.hw2course4.dto.EmployeeFullInfo;
import ru.skypro.hw2.course4.hw2course4.model.Employee;
import ru.skypro.hw2.course4.hw2course4.model.Position;
import ru.skypro.hw2.course4.hw2course4.service.EmployeeServiceImpl;

import java.util.List;

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

    @PostMapping("/addEmployees")
    public void addEmployee(@RequestParam(required = false) String name,
                            @RequestParam(required = false) int salary,
                            @RequestParam Position position) {
        employeeService.addEmployee(new EmployeeDTO(name, salary, position));
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
    public List<EmployeeDTO> getEmployeeWithMaxSalary() {
        return employeeService.getEmployeeWithMaxSalary();
    }

    @GetMapping("/fullInfo")
    public List<EmployeeFullInfo> getEmployeeFullInformation() {
        return employeeService.getEmployeeFullInfo();
    }

    @GetMapping("/{id}/fullInfo")
    public EmployeeDTO getInfoById(@RequestParam int id) {
        return employeeService.getFullInfoById(id);
    }

    @GetMapping("/EmployeesPages")
    public List<EmployeeDTO> getEmployeesForPosition
            (@RequestParam(required = false, defaultValue = "0") int page) {
        return employeeService.getEmployeeByPage(page);
    }

    @GetMapping("/employees/position")
    public List<EmployeeDTO> getEmployeesOnPosition
            (@RequestParam(value = "position", required = false) String positionName) {
        return employeeService.getEmployeesOnPosition(positionName);
    }

}
