package project.from.aigerim.rentcarskg.mapper;

import org.mapstruct.Mapper;
import project.from.aigerim.rentcarskg.entity.Car;
import project.from.aigerim.rentcarskg.entity.dto.CarDto;

import java.util.List;

@Mapper
public interface CarMapper {
    Car toEntity(CarDto carDto);

    CarDto toDto(Car car);

    List<CarDto> toDtoList(List<Car> cars);
}
