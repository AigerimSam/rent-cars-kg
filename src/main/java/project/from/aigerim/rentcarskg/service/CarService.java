package project.from.aigerim.rentcarskg.service;

import project.from.aigerim.rentcarskg.entity.dto.CarDto;

import java.util.List;
import java.util.UUID;

public interface CarService {
    CarDto save(CarDto carDto);

    CarDto findById(UUID id);

    List<CarDto> findAll();

    CarDto update(CarDto carDto, UUID id);

    void delete(UUID id);
}
