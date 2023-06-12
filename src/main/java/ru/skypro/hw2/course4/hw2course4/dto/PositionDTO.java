package ru.skypro.hw2.course4.hw2course4.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.skypro.hw2.course4.hw2course4.model.Position;

@Getter
@Setter
@NoArgsConstructor
public class PositionDTO {
    private int id;
    private String positionName;

    public PositionDTO(String position) {
        this.positionName = position;
    }

    public static PositionDTO fromPosition(Position position) {
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setId(position.getId());
        positionDTO.setPositionName(position.getPositionName());
        return positionDTO;
    }

    public Position toPosition(PositionDTO positionDTO) {
        Position position = new Position();
        position.setId(this.getId());
        position.setPositionName(this.getPositionName());
        return position;
    }
}
