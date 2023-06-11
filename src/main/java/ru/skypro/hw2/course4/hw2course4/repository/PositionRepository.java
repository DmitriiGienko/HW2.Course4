package ru.skypro.hw2.course4.hw2course4.repository;

import org.springframework.data.repository.CrudRepository;
import ru.skypro.hw2.course4.hw2course4.dto.PositionDTO;
import ru.skypro.hw2.course4.hw2course4.model.Position;

public interface PositionRepository extends CrudRepository<Position, Integer> {
}
