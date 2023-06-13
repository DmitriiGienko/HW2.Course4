package ru.skypro.hw2.course4.hw2course4.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.hw2.course4.hw2course4.dto.EmployeeDTO;
import ru.skypro.hw2.course4.hw2course4.dto.PositionDTO;
import ru.skypro.hw2.course4.hw2course4.repository.PositionRepository;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public void addPosition(PositionDTO positionDTO) {
        positionRepository.save(positionDTO.toPosition(positionDTO));
    }
}

