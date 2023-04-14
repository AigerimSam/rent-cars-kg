package project.from.aigerim.rentcarskg.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import project.from.aigerim.rentcarskg.entity.Address;

import java.time.LocalDateTime;

@Data
public class OrderDto {
    private Long id;
    private CarDto carDto;
    private Boolean babySeat;
    private Boolean withDriver;
    private String clientName;
    private String clientPhone;
    private String clientEmail;
    private Address getAddress;
    private Address returnAddress;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTimeFrom;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTimeTo;
    private Integer countOfDays;
    private Double price;
    private Double discount;
    private Double priceBeforeDiscount;
    private Double priceWithDiscount;

}
