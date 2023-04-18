package project.from.aigerim.rentcarskg.mapper;

import org.mapstruct.Mapper;
import project.from.aigerim.rentcarskg.entity.Discount;
import project.from.aigerim.rentcarskg.entity.dto.DiscountDto;

import java.util.List;

@Mapper
public interface DiscountMapper {
    Discount toEntity(DiscountDto discountDto);

    DiscountDto toDto(Discount discount);

    List<DiscountDto> toDtoList(List<Discount> discounts);
}
