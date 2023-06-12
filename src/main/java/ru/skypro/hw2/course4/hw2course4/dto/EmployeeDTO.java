package ru.skypro.hw2.course4.hw2course4.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import ru.skypro.hw2.course4.hw2course4.model.Employee;
import ru.skypro.hw2.course4.hw2course4.model.Position;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)

@Data
@NoArgsConstructor
public class EmployeeDTO {
    private Integer id;
    private String name;
    private Integer salary;
    private String position;

    public EmployeeDTO(Integer id, String name, Integer salary, String position) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.position = position;
    }

    public EmployeeDTO(String name, Integer salary, String position) {
        this.name = name;
        this.salary = salary;
        this.position = position;
    }

    public EmployeeDTO(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    public static EmployeeDTO fromEmployee(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setPosition(Optional.ofNullable(employee.getPosition())
                .map(Position::getPositionName)
                .orElse(null));
        return employeeDTO;
    }

    public Employee toEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(this.getId());
        employee.setName(this.getName());
        employee.setSalary(this.getSalary());
        return employee;
    }


}
