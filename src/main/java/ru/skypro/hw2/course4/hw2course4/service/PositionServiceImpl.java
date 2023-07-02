package ru.skypro.hw2.course4.hw2course4.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(PositionServiceImpl.class);

    @Override
    public void addPosition(Position position) {
        logger.info("Вызван метод создания отдела {}", position);
        positionRepository.save(position);
        logger.debug("Отдел {} создан", position);

    }

    public List<Position> getAllPosition() {
        logger.info("Вызван метод получения всех отделов");
        List<Position> positionList = new ArrayList<>();
        for (Position position : positionRepository.findAll()) {
            positionList.add(position);
        }
        logger.debug("Отделы получены: {}", positionList);
        return positionList;
    }


}
