package project.from.aigerim.rentcarskg.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "tb_car_busy_day")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CarBusyDays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate busyDay;
}
