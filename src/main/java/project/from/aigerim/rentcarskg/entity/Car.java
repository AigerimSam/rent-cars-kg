package project.from.aigerim.rentcarskg.entity;

import lombok.*;
import project.from.aigerim.rentcarskg.entity.enums.Category;
import project.from.aigerim.rentcarskg.entity.enums.Color;
import project.from.aigerim.rentcarskg.entity.enums.EngineType;
import project.from.aigerim.rentcarskg.entity.enums.Transmission;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tb_car")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String photo;
    private LocalDate mnfYear;
    @Enumerated(EnumType.STRING)
    private Color color;
    private Double engineVolume;
    @Enumerated(EnumType.STRING)
    private EngineType engineType;
    @Enumerated(EnumType.STRING)
    private Transmission transmission;
    private Integer gasPer100;
    @Enumerated(EnumType.STRING)
    private Category category;
    private Boolean isAvailable;
    @OneToMany(cascade = CascadeType.ALL)
    private List<CarBusyDays> carBusyDays;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Price> price;
}
