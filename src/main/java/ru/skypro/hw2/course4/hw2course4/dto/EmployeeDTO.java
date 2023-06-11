package ru.skypro.hw2.course4.hw2course4.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.skypro.hw2.course4.hw2course4.model.Employee;

@Setter
@Getter
@NoArgsConstructor
public class EmployeeDTO {
    private int id;
    private String name;
    private int salary;

    public EmployeeDTO(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public static EmployeeDTO fromEmployee(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSalary(employee.getSalary());
        return employeeDTO;
    }

    public  Employee toEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(this.getId());
        employee.setName(this.getName());
        employee.setSalary(this.getSalary());
        return employee;
    }
}
