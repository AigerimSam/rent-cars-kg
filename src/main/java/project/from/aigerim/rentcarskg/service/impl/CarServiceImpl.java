package project.from.aigerim.rentcarskg.service.impl;

import liquibase.pro.packaged.L;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.from.aigerim.rentcarskg.entity.CarBusyDaysEntity;
import project.from.aigerim.rentcarskg.entity.CarEntity;
import project.from.aigerim.rentcarskg.entity.PriceEntity;
import project.from.aigerim.rentcarskg.entity.dto.CarDto;
import project.from.aigerim.rentcarskg.mapper.CarMapper;
import project.from.aigerim.rentcarskg.repository.CarRepository;
import project.from.aigerim.rentcarskg.service.CarService;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarServiceImpl implements CarService {
    private final CarMapper mapper;
    private final CarRepository repository;

    @Override
    public CarDto save(CarDto carDto) {
        CarEntity entity = mapper.toEntity(carDto);
        CarEntity saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public CarDto findById(UUID id) {
        Optional<CarEntity> entity = repository.findById(id);
        if (entity.isPresent()) {
            CarEntity car = entity.get();
            PriceEntity activePrice = findActivePrice(car.getPrices());
            if (activePrice == null) {
                log.error("Car is not available today");
                return null;
            } else {
                car.setPrices(Collections.singletonList(activePrice));
                return mapper.toDto(car);
            }
        }
        else {
            log.error("Can not find car by id {}", id);
            return null;
        }
    }

    @Override
    public List<CarDto> findAll() {
        List<CarEntity> cars = repository.findAll();
        List<CarEntity> result = new ArrayList<>();
        for (CarEntity car : cars) {
            PriceEntity activePrice = findActivePrice(car.getPrices());
            if (activePrice == null) {
                log.error("Car is not available today");
            } else {
                car.setPrices(Collections.singletonList(activePrice));
                result.add(car);
            }
        }
        return mapper.toDtoList(result);
    }

    @Override
    public CarDto update(CarDto carDto, UUID id) {
        Optional<CarEntity> optionalEntity = repository.findById(id);
        if (!optionalEntity.isPresent()) {
            log.error("Can not find car by id: {}", id);
            return null;
        } else {
            CarEntity update = mergeEntity(optionalEntity.get(), mapper.toEntity(carDto));
            return mapper.toDto(repository.save(update));
        }
    }

    @Override
    public void delete(UUID id) {
        Optional<CarEntity> entity = repository.findById(id);
        if (!entity.isPresent()) {
            log.error("Can not find car by id: {}", id);
        } else {
            repository.delete(entity.get());
        }
    }

    private CarEntity mergeEntity(CarEntity entity, CarEntity update) {
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
        entity.setDiscounts(update.getDiscounts());
        return entity;
    }

    private PriceEntity findActivePrice(List<PriceEntity> prices) {
        for (PriceEntity price : prices) {
            if (price.getStartDate().isBefore(LocalDate.now()) && price.getEndDate().isAfter(LocalDate.now())) {
                return price;
            }
        }
        return null;
    }

    public void updateCarBusyDays(CarEntity carEntity){
        repository.save(carEntity);
    }
}