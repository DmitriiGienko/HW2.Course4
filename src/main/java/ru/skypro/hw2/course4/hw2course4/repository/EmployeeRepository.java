package ru.skypro.hw2.course4.hw2course4.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.skypro.hw2.course4.hw2course4.model.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> findByName(String name);

//    List<Employee> getEmployeeBySalaryGreaterThan(@Param("salary") int salary);

    @Query(value = "UPDATE employee SET name=: name, salary =: salary WHERE id=:id",
            nativeQuery = true)
    void updateEmployeeByID(@Param("name") String name,
                            @Param("salary") int salary,
                            @Param("id") int id);

}
