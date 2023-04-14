package project.from.aigerim.rentcarskg.entity.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DiscountDto {
    private Long id;
    private CarDto carDto;
    private Double discount;
    private Integer days;
    private LocalDate startDate;
    private LocalDate endDate;
}
