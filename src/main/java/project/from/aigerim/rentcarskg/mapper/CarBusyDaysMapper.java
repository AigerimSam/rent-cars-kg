package project.from.aigerim.rentcarskg.mapper;

import org.mapstruct.Mapper;
import project.from.aigerim.rentcarskg.entity.CarBusyDaysEntity;
import project.from.aigerim.rentcarskg.entity.dto.CarBusyDaysDto;

import java.util.List;

@Mapper
public interface CarBusyDaysMapper {
    CarBusyDaysEntity toEntity(CarBusyDaysDto carBusyDaysDto);

    CarBusyDaysDto toDto(CarBusyDaysEntity carBusyDays);

    List<CarBusyDaysDto> toDtoList(List<CarBusyDaysEntity> days);
}