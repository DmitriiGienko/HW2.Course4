package ru.skypro.hw2.course4.hw2course4.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.skypro.hw2.course4.hw2course4.model.Report;
import ru.skypro.hw2.course4.hw2course4.projections.ReportProjection;

import java.util.List;

public interface ReportRepository extends CrudRepository<Report, Integer> {

    @Query("SELECT new ru.skypro.hw2.course4.hw2course4.projections.ReportProjection" +
            " (p.positionName, COUNT(e) , MIN(e.salary), MAX(e.salary), AVG (e.salary)) " +
            "FROM Employee e JOIN FETCH  Position p WHERE e.position = p GROUP BY p.positionName")
    List<ReportProjection> getReport();
}
