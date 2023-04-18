package project.from.aigerim.rentcarskg.entity;

import lombok.*;
import project.from.aigerim.rentcarskg.enums.Category;
import project.from.aigerim.rentcarskg.enums.Color;
import project.from.aigerim.rentcarskg.enums.EngineType;
import project.from.aigerim.rentcarskg.enums.Transmission;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_car")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CarEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "model")
    private String model;
    @Column(name = "photo")
    private String photo;
    @Column(name = "mnf_year")
    private LocalDate mnfYear;
    @Enumerated(EnumType.STRING)
    @Column(name = "color")
    private Color color;
    @Column(name = "engine_volume")
    private Double engineVolume;
    @Enumerated(EnumType.STRING)
    @Column(name = "engine_type")
    private EngineType engineType;
    @Enumerated(EnumType.STRING)
    @Column(name = "transmission")
    private Transmission transmission;
    @Column(name = "gas_per100")
    private Integer gasPer100;
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;
    @Column(name = "is_available")
    private Boolean isAvailable;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_car_car_busy_days",
            joinColumns = {@JoinColumn(name = "car_id")},
            inverseJoinColumns = {@JoinColumn(name = "car_busy_days_id")})
    private List<CarBusyDaysEntity> carBusyDays;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_car_price",
            joinColumns = {@JoinColumn(name = "car_id")},
            inverseJoinColumns = {@JoinColumn(name = "prices_id")})
    private List<PriceEntity> prices;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_car_discount",
            joinColumns = {@JoinColumn(name = "car_id")},
            inverseJoinColumns = {@JoinColumn(name = "discount_id")})
    private List<Discount> discounts;
}