package project.from.aigerim.rentcarskg.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project.from.aigerim.rentcarskg.entity.dto.OrderDto;
import project.from.aigerim.rentcarskg.service.OrderService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
@Validated
public class OrderController {
    private final OrderService service;

    @PostMapping
    @ApiOperation("Create order")
    public OrderDto save(@Valid @RequestBody OrderDto orderDto) {
        return service.save(orderDto);
    }

    @GetMapping("/{id}")
    @ApiOperation("Find order by id")
    public OrderDto findById(@PathVariable("id") UUID id) {
        return service.findById(id);
    }

    @GetMapping
    @ApiOperation("Find all orders")
    public List<OrderDto> findAll() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    @ApiOperation("Update order by id")
    public OrderDto update(@Valid @RequestBody OrderDto orderDto, @PathVariable("id") UUID id) {
        return service.update(orderDto, id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete order by id")
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }
}
