package project.from.aigerim.rentcarskg.entity.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Validated
public class PriceDto {
    private UUID id;
    @NotNull
    private Double price;
    @NotEmpty
    private LocalDate startDate;
    @NotEmpty
    private LocalDate endDate;
}
