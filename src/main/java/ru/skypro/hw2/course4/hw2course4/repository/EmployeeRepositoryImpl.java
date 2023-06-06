package ru.skypro.hw2.course4.hw2course4.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.skypro.hw2.course4.hw2course4.pojo.Employee;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {



    private List<Employee> employeeList = new ArrayList<>();


    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }
}
