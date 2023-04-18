package project.from.aigerim.rentcarskg.mapper;

import org.mapstruct.Mapper;
import project.from.aigerim.rentcarskg.entity.CarEntity;
import project.from.aigerim.rentcarskg.entity.dto.CarDto;

import java.util.List;

@Mapper
public interface CarMapper {
    CarEntity toEntity(CarDto carDto);

    CarDto toDto(CarEntity carEntity);

    List<CarDto> toDtoList(List<CarEntity> carEntities);
}
