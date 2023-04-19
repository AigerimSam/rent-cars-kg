package project.from.aigerim.rentcarskg.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.from.aigerim.rentcarskg.entity.CarBusyDaysEntity;
import project.from.aigerim.rentcarskg.entity.CarEntity;
import project.from.aigerim.rentcarskg.entity.DiscountEntity;
import project.from.aigerim.rentcarskg.entity.OrderEntity;
import project.from.aigerim.rentcarskg.entity.dto.OrderDto;
import project.from.aigerim.rentcarskg.mapper.OrderMapper;
import project.from.aigerim.rentcarskg.repository.OrderRepository;
import project.from.aigerim.rentcarskg.service.OrderService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final CarServiceImpl carService;

    @Override
    public OrderDto save(OrderDto orderDto) {
        OrderEntity entity = mapper.toEntity(orderDto);
        boolean isAvailable = isAvailableDays(entity.getCar().getCarBusyDays(),
                busyDays(entity.getDateTimeFrom().toLocalDate(),
                        entity.getDateTimeTo().toLocalDate()));
        if (!isAvailable) {
            log.error("Сar is busy on selected days");
            return null;
        } else {
            entity.setCountOfDays();
            entity.setDiscount(calculateDiscount(entity.getCar(), entity.getCountOfDays()));
            entity.setPriceBeforeDiscount(calculatePriceBeforeDiscount(entity.getCar().getPrices().get(0).getPrice(), entity.getCountOfDays()));
            entity.setPriceWithDiscount(calculatePriceWithDiscount(entity.getDiscount(), entity.getPriceBeforeDiscount()));
            OrderEntity saved = repository.save(entity);
            CarEntity car = entity.getCar();
            car.setCarBusyDays(busyDays(entity.getDateTimeFrom().toLocalDate(), entity.getDateTimeTo().toLocalDate()));
            carService.updateCarBusyDays(car);
            return mapper.toDto(saved);
        }
    }

    private boolean isAvailableDays(List<CarBusyDaysEntity> carBusyDays, List<CarBusyDaysEntity> busyDays) {
        for (CarBusyDaysEntity days : carBusyDays) {
            for (CarBusyDaysEntity newDays : busyDays) {
                if (days.getBusyDay().equals(newDays.getBusyDay())) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public OrderDto findById(UUID id) {
        Optional<OrderEntity> entity = repository.findById(id);
        return entity.map(mapper::toDto).orElse(null);
    }

    @Override
    public List<OrderDto> findAll() {
        return mapper.toDtoLIst(repository.findAll());
    }

    @Override
    public OrderDto update(OrderDto orderDto, UUID id) {
        Optional<OrderEntity> optionalEntity = repository.findById(id);
        if (!optionalEntity.isPresent()) {
            log.error("Can not find order by id: {}", id);
            return null;
        } else {
            OrderEntity update = mergeEntity(optionalEntity.get(), mapper.toEntity(orderDto));
            return mapper.toDto(repository.save(update));
        }
    }

    @Override
    public void delete(UUID id) {
        Optional<OrderEntity> entity = repository.findById(id);
        if (!entity.isPresent()) {
            log.error("Can not find car by id: {}", id);
        } else {
            repository.delete(entity.get());
        }
    }

    private OrderEntity mergeEntity(OrderEntity entity, OrderEntity update) {
        entity.setCar(update.getCar());
        entity.setBabySeat(update.getBabySeat());
        entity.setWithDriver(update.getWithDriver());
        entity.setClientName(update.getClientName());
        entity.setClientPhone(update.getClientPhone());
        entity.setClientEmail(update.getClientEmail());
        entity.setTakeAddress(update.getTakeAddress());
        entity.setReturnAddress(update.getReturnAddress());
        entity.setDateTimeTo(update.getDateTimeTo());
        entity.setDateTimeFrom(update.getDateTimeFrom());
        entity.setCountOfDays(update.getCountOfDays());
        entity.setPriceBeforeDiscount(update.getPriceBeforeDiscount());
        entity.setPriceWithDiscount(update.getPriceWithDiscount());
        return entity;
    }

    private List<CarBusyDaysEntity> busyDays(LocalDate start, LocalDate end) {
        List<CarBusyDaysEntity> carBusyDays = new ArrayList<>();
        List<LocalDate> dates = start.datesUntil(end).collect(Collectors.toList());
        for (LocalDate date : dates) {
            CarBusyDaysEntity carBusyDay = new CarBusyDaysEntity();
            carBusyDay.setBusyDay(date);
            carBusyDays.add(carBusyDay);
        }
        return carBusyDays;
    }

    private Double calculateDiscount(CarEntity car, Integer countOfDays) {
        List<DiscountEntity> discounts = car.getDiscounts();
        if (discounts == null || discounts.isEmpty()) {
            return 0.0;
        }
        DiscountEntity resultDiscount = null;
        int countDays = countOfDays;
        for (DiscountEntity discount : discounts) {
            if (countDays >= discount.getDays()) {
                resultDiscount = discount;
            }
        }
        assert resultDiscount != null;
        return resultDiscount.getDiscount();
    }

    private Double calculatePriceWithDiscount(Double discount, Double priceBeforeDiscount) {
        return (priceBeforeDiscount * (100 - discount)) / 100;
    }

    private Double calculatePriceBeforeDiscount(Double prices, Integer countOfDays) {
        return prices * countOfDays;
    }


}
