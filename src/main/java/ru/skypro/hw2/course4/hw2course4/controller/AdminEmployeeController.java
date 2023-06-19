package ru.skypro.hw2.course4.hw2course4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.hw2.course4.hw2course4.projections.EmployeeFullInfo;
import ru.skypro.hw2.course4.hw2course4.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/admin/employees")
public class AdminEmployeeController {
    private final EmployeeService employeeService;

    public AdminEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/all")
    public List<EmployeeFullInfo> getEmployees() {
        return employeeService.getEmployeeFullInfo();
    }
}
