package ru.skypro.hw2.course4.hw2course4.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.skypro.hw2.course4.hw2course4.model.Employee;
import ru.skypro.hw2.course4.hw2course4.model.Position;

@Getter
@Setter
@NoArgsConstructor
public class PositionDTO {
    private int id;
    private String position;

    public PositionDTO(String position) {
        this.position = position;
    }

    public static PositionDTO fromPosition(Position position) {
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setId(position.getId());
        positionDTO.setPosition(position.getPosition());
        return positionDTO;
    }

    public Position toPosition(PositionDTO positionDTO) {
        Position position = new Position();
        position.setId(this.getId());
        position.setPosition(this.getPosition());
        return position;
    }
}
