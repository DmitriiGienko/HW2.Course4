package ru.skypro.hw2.course4.hw2course4.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.hw2.course4.hw2course4.dto.EmployeeDTO;
import ru.skypro.hw2.course4.hw2course4.dto.PositionDTO;
import ru.skypro.hw2.course4.hw2course4.service.PositionServiceImpl;

@RestController
@RequestMapping("/position")

public class PositionController {

    private final PositionServiceImpl positionService;

    public PositionController(PositionServiceImpl positionService) {
        this.positionService = positionService;
    }

    @PostMapping("/addPosition")
    public void addPosition(@RequestParam String position) {
        positionService.addPosition(new PositionDTO(position));
    }
}
