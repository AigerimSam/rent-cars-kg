package project.from.aigerim.rentcarskg.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_discount")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Discount {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "discount")
    private Double discount;
    @Column(name = "day")
    private Integer days;
    @Column(name = "start_day")
    private LocalDate startDate;
    @Column(name = "end_day")
    private LocalDate endDate;
}