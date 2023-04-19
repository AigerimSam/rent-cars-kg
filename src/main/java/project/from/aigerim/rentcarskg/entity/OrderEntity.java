package project.from.aigerim.rentcarskg.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.UUID;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    private CarEntity car;
    @Column(name = "baby_seat")
    private Boolean babySeat;
    @Column(name = "with_driver")
    private Boolean withDriver;
    @Column(name = "client_name")
    private String clientName;
    @Column(name = "client_phone")
    private String clientPhone;
    @Column(name = "client_email")
    private String clientEmail;
    @OneToOne
    private AddressEntity takeAddress;
    @OneToOne
    private AddressEntity returnAddress;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "date_time_from")
    private LocalDateTime dateTimeFrom;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "date_time_to")
    private LocalDateTime dateTimeTo;
    @Column(name = "count_of_days")
    private Integer countOfDays;
    @Column(name = "discount")
    private Double discount;
    @Column(name = "price_before_discount")
    private Double priceBeforeDiscount;
    @Column(name = "price_with_discount")
    private Double priceWithDiscount;

    public void setCountOfDays() {
        this.countOfDays = Period.between(dateTimeFrom.toLocalDate(), dateTimeTo.toLocalDate()).getDays();
    }
}