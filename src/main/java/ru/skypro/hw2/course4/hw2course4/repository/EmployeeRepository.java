package ru.skypro.hw2.course4.hw2course4.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.skypro.hw2.course4.hw2course4.pojo.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query(value = "UPDATE employee SET name= :newName, salary= :newSalary WHERE id= :id",
            nativeQuery = true)
    void updateEmployeeById(@Param("newName") String name,
                            @Param("newSalary") int salary,
                            @Param("id") int id);

    List<Employee> findEmployeeBySalaryGreaterThan(int salary);
}
