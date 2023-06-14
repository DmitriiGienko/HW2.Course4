package ru.skypro.hw2.course4.hw2course4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.hw2.course4.hw2course4.model.Position;
import ru.skypro.hw2.course4.hw2course4.service.PositionServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {

    private final PositionServiceImpl positionService;

    public PositionController(PositionServiceImpl positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/addPosition")
    public void addPosition(@RequestParam String positionName) {
        positionService.addPosition(new Position(positionName));
    }

    @GetMapping("/showPosition")
    public List<Position> getAllPosition() {
        return positionService.getAllPosition();
    }
}
