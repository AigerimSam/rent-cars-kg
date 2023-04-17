package project.from.aigerim.rentcarskg.entity.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Validated
public class CarBusyDaysDto {
    private UUID id;
    private LocalDate busyDay;
}
