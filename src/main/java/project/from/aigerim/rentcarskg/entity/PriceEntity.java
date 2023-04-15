package project.from.aigerim.rentcarskg.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_price")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PriceEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "price")
    private Double price;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;

}
