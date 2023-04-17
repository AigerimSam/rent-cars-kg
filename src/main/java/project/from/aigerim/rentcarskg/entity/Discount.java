package project.from.aigerim.rentcarskg.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
//    @ManyToOne
//    @OnDelete(action = OnDeleteAction.CASCADE)
    //private Car car;
    private Double discount;
    private Integer days;
    private LocalDate startDate;
    private LocalDate endDate;
}

