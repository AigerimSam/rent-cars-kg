package project.from.aigerim.rentcarskg.entity.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class CarBusyDaysDto {
    private UUID id;
    private LocalDate busyDay;
}
