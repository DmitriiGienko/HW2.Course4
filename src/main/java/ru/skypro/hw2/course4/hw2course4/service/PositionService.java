package ru.skypro.hw2.course4.hw2course4.service;

import ru.skypro.hw2.course4.hw2course4.model.Position;

import java.util.List;

public interface PositionService {
    void addPosition(Position position);

    List<Position> getAllPosition();
}
