package project.from.aigerim.rentcarskg.entity.dto;

import lombok.Data;

@Data
public class AddressDto {
    private Long id;
    private String city;
    private String street;
    private Integer buildingNum;
}
