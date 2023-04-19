package project.from.aigerim.rentcarskg.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Validated
public class OrderDto {
    private UUID id;
    @NotNull
    private CarDto car;
    private Boolean babySeat;
    private Boolean withDriver;
    @NotNull
    @NotEmpty
    private String clientName;
    @NotNull
    @NotEmpty
    private String clientPhone;
    @NotNull
    @NotEmpty
    private String clientEmail;
    @NotNull
    private AddressDto takeAddress;
    @NotNull
    private AddressDto returnAddress;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTimeFrom;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTimeTo;
    private Integer countOfDays;
    private Double discount;
    private Double priceBeforeDiscount;
    private Double priceWithDiscount;
}
