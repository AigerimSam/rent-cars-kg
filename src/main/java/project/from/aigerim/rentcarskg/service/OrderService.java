package project.from.aigerim.rentcarskg.service;

import project.from.aigerim.rentcarskg.entity.dto.OrderDto;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    OrderDto save(OrderDto orderDto);

    OrderDto findById(UUID id);

    List<OrderDto> findAll();

    OrderDto update(OrderDto orderDto, UUID id);

    void delete(UUID id);


}
