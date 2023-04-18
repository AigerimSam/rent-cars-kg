package project.from.aigerim.rentcarskg.entity.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Validated
public class DiscountDto {
    private UUID id;
    @NotNull
    private Double discount;
    @NotNull
    private Integer days;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
}