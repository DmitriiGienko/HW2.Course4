package ru.skypro.hw2.course4.hw2course4.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.hw2.course4.hw2course4.model.Employee;
import ru.skypro.hw2.course4.hw2course4.model.Position;
import ru.skypro.hw2.course4.hw2course4.repository.PositionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PositionServiceImpl implements PositionService {

    private PositionRepository positionRepository;

    @Override
    public void addPosition(Position position) {
        positionRepository.save(position);
    }

    @Override
    public List<Position> getAllPosition() {
        List<Position> positionList = new ArrayList<>();
        for (Position position : positionRepository.findAll()) {
            positionList.add(position);
        }
        return positionList;
    }


}
