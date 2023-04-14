package project.from.aigerim.rentcarskg.entity.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CarBusyDaysDto {
    private Long id;
    private LocalDate busyDay;
}
