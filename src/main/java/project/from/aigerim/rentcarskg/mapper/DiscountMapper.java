package project.from.aigerim.rentcarskg.mapper;

import org.mapstruct.Mapper;
import project.from.aigerim.rentcarskg.entity.DiscountEntity;
import project.from.aigerim.rentcarskg.entity.dto.DiscountDto;

import java.util.List;

@Mapper
public interface DiscountMapper {
    DiscountEntity toEntity(DiscountDto discountDto);

    DiscountDto toDto(DiscountEntity discountEntity);

    List<DiscountDto> toDtoList(List<DiscountEntity> discountEntities);
}
