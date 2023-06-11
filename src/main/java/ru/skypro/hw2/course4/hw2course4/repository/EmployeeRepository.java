package ru.skypro.hw2.course4.hw2course4.repository;

import org.springframework.data.repository.CrudRepository;
import ru.skypro.hw2.course4.hw2course4.pojo.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {



}
