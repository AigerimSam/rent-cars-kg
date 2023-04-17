package project.from.aigerim.rentcarskg.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project.from.aigerim.rentcarskg.entity.dto.CarDto;
import project.from.aigerim.rentcarskg.service.CarService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor
@Validated
public class CarController {
    private final CarService service;

    @PostMapping
    @ApiOperation("Create car")
    public CarDto save(@Valid @RequestBody CarDto carDto) {
        return service.save(carDto);
    }

    @GetMapping("/{id}")
    @ApiOperation("Find car by id")
    public CarDto findById(@PathVariable("id") UUID id) {
        return service.findById(id);
    }

    @GetMapping
    @ApiOperation("Find all cars")
    public List<CarDto> findAll() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    @ApiOperation("Update car by id")
    public CarDto update(@Valid @RequestBody CarDto carDto, @PathVariable("id") UUID id) {
        return service.update(carDto, id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete car by id")
    public void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }
}
