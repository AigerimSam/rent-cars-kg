package project.from.aigerim.rentcarskg.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.from.aigerim.rentcarskg.entity.Car;
import project.from.aigerim.rentcarskg.entity.dto.CarDto;
import project.from.aigerim.rentcarskg.mapper.CarMapper;
import project.from.aigerim.rentcarskg.repository.CarRepository;
import project.from.aigerim.rentcarskg.service.CarService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarServiceImpl implements CarService {
    private final CarMapper mapper;
    private final CarRepository repository;

    @Override
    public CarDto save(CarDto carDto) {
        Car entity = mapper.toEntity(carDto);
        Car saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public CarDto findById(UUID id) {
        Optional<Car> entity = repository.findById(id);
        return entity.map(mapper::toDto).orElse(null);
    }

    @Override
    public List<CarDto> findAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public CarDto update(CarDto carDto, UUID id) {
        Optional<Car> optionalEntity = repository.findById(id);
        if (!optionalEntity.isPresent()) {
            log.error("Can not find car by id: {}", id);
            return null;
        } else {
            Car update = mergeEntity(optionalEntity.get(), mapper.toEntity(carDto));
            return mapper.toDto(repository.save(update));
        }
    }

    @Override
    public void delete(UUID id) {
        Optional<Car> entity = repository.findById(id);
        if (!entity.isPresent()) {
            log.error("Can not find car by id: {}", id);
        } else {
            repository.delete(entity.get());
        }
    }

    private Car mergeEntity(Car entity, Car update) {
        entity.setModel(update.getModel());
        entity.setPhoto(update.getPhoto());
        entity.setMnfYear(update.getMnfYear());
        entity.setColor(update.getColor());
        entity.setEngineType(update.getEngineType());
        entity.setTransmission(update.getTransmission());
        entity.setGasPer100(update.getGasPer100());
        entity.setCategory(update.getCategory());
        entity.setIsAvailable(update.getIsAvailable());
        entity.setCarBusyDays(update.getCarBusyDays());
        entity.setPrices(update.getPrices());
        return entity;
    }
}
