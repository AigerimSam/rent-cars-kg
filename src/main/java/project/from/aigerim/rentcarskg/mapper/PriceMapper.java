package project.from.aigerim.rentcarskg.mapper;

import org.mapstruct.Mapper;
import project.from.aigerim.rentcarskg.entity.PriceEntity;
import project.from.aigerim.rentcarskg.entity.dto.PriceDto;

import java.util.List;

@Mapper
public interface PriceMapper {
    PriceEntity toEntity(PriceDto priceDto);

    PriceDto toDto(PriceEntity priceEntity);

    List<PriceDto> toDtoList(List<PriceEntity> prices);
}
