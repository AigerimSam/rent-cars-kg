package project.from.aigerim.rentcarskg.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Car car;
    private Boolean babySeat;
    private Boolean withDriver;
    private String clientName;
    private String clientPhone;
    private String clientEmail;
    @OneToOne
    private Address getAddress;
    @OneToOne
    private Address returnAddress;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "date_time_from")
    private LocalDateTime dateTimeFrom;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "date_time_to")
    private LocalDateTime dateTimeTo;
    @Column(name = "count_of_days")
    private Integer countOfDays;
    @Column(name = "price")
    private Double price;
    private Double discount;
    @Column(name = "price_before_discount")
    private Double priceBeforeDiscount;
    @Column(name = "price_with_discount")
    private Double priceWithDiscount;

    public void setCountOfDays() {
        this.countOfDays = Period.between(dateTimeFrom.toLocalDate(), dateTimeTo.toLocalDate()).getDays();
    }
}

