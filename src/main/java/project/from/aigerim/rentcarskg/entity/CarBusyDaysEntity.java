package project.from.aigerim.rentcarskg.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_cars_busy_days")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CarBusyDaysEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "busy_day")
    private LocalDate busyDay;
}
