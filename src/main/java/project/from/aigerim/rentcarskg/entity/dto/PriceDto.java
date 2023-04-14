package project.from.aigerim.rentcarskg.entity.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PriceDto {
    private Long id;
    private Double price;
    private LocalDate startDate;
    private LocalDate endDate;
}