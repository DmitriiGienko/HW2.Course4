package ru.skypro.hw2.course4.hw2course4.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.skypro.hw2.course4.hw2course4.dto.EmployeeDTO;
import ru.skypro.hw2.course4.hw2course4.dto.EmployeeFullInfo;
import ru.skypro.hw2.course4.hw2course4.model.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {


    List<Employee> findEmployeeBySalaryGreaterThan(int salary);

    @Query("SELECT new ru.skypro.hw2.course4.hw2course4.dto.EmployeeDTO" +
            "(e.name, e.salary, e.position)" +
            " FROM Employee e left join Position p" +
            " on p.id = e.position.id" +
            " where e.salary = (SELECT MAX(e.salary) from Employee e)")
    List<EmployeeDTO> getEmployeesWithMaxSalary();

    @Query("SELECT new ru.skypro.hw2.course4.hw2course4.dto.EmployeeFullInfo" +
            "(e.name, e.salary, p.positionName)" +
            " FROM Employee e" +
            " JOIN FETCH Position p" +
            " WHERE e.position=p")
    List<EmployeeFullInfo> getFullInfo();

    @Query("SELECT new ru.skypro.hw2.course4.hw2course4.dto.EmployeeFullInfo" +
            "(e.name , e.salary , p.positionName) " +
            "FROM Employee e " +
            "JOIN FETCH Position p " +
            "WHERE e.position = p")
    List<EmployeeFullInfo> findAllEmployeeFullInfo();

    @Query(value = "SELECT e FROM Employee e JOIN FETCH Position p ON e.position = p " +
            "WHERE e.position.positionName = :name")
    List<Employee> findByPositionName(@Param("name") String name);
}
