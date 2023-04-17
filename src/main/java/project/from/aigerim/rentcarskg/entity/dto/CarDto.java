package project.from.aigerim.rentcarskg.entity.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;
import project.from.aigerim.rentcarskg.enums.Category;
import project.from.aigerim.rentcarskg.enums.Color;
import project.from.aigerim.rentcarskg.enums.EngineType;
import project.from.aigerim.rentcarskg.enums.Transmission;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Validated
public class CarDto {
    private UUID id;
    @NotNull
    @NotEmpty
    private String model;
    private String photo;
    @NotNull
    private LocalDate mnfYear;
    @NotNull
    private Color color;
    @NotNull
    private Double engineVolume;
    @NotNull
    private EngineType engineType;
    @NotNull
    private Transmission transmission;
    @NotNull
    private Integer gasPer100;
    @NotNull
    private Category category;
    private Boolean isAvailable;
    private List<CarBusyDaysDto> carBusyDays;
    @NotNull
    @NotEmpty
    private List<PriceDto> prices;
}
