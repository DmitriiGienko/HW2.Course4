package ru.skypro.hw2.course4.hw2course4.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.skypro.hw2.course4.hw2course4.dto.EmployeeDTO;
import ru.skypro.hw2.course4.hw2course4.dto.EmployeeFullInfo;
import ru.skypro.hw2.course4.hw2course4.model.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query(value = "UPDATE employee SET name= :newName, salary= :newSalary WHERE id= :id",
            nativeQuery = true)
    void updateEmployeeById(@Param("newName") String name,
                            @Param("newSalary") int salary,
                            @Param("id") int id);

    List<Employee> findEmployeeBySalaryGreaterThan(int salary);

    @Query("SELECT new ru.skypro.hw2.course4.hw2course4.dto.EmployeeDTO(e.id, e.name, e.salary, e.position.positionName)" +
            " FROM Employee e left join Position p" +
            " on p.id = e.position.id" +
            " where e.salary = (SELECT MAX(e.salary) from Employee e)")
    List<EmployeeDTO> getEmployeeWithMaxSalary();

    @Query("SELECT new ru.skypro.hw2.course4.hw2course4.dto.EmployeeFullInfo" +
            "(e.name , e.salary , p.positionName) " +
            "FROM Employee e " +
            "JOIN FETCH Position p " +
            "WHERE e.position = p")
    List<EmployeeFullInfo> findAllEmployeeFullInfo();

    List<Employee> findEmployeeByPosition_Position(String position);
}


