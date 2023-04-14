package project.from.aigerim.rentcarskg.entity.dto;

import lombok.Data;
import project.from.aigerim.rentcarskg.entity.Order;
import project.from.aigerim.rentcarskg.entity.Price;
import project.from.aigerim.rentcarskg.entity.enums.Category;
import project.from.aigerim.rentcarskg.entity.enums.Color;
import project.from.aigerim.rentcarskg.entity.enums.EngineType;
import project.from.aigerim.rentcarskg.entity.enums.Transmission;

import java.time.LocalDate;
import java.util.List;

@Data
public class CarDto {

    private Long id;
    private String model;
    private String photo;
    private LocalDate mnfYear;
    private Color color;
    private Double engineVolume;
    private EngineType engineType;
    private Transmission transmission;
    private Integer gasPer100;
    private Category category;
    private Boolean isAvailable;
    private List<CarBusyDaysDto> carBusyDays;
    private List<PriceDto> prices;
}