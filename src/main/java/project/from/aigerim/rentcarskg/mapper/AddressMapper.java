package project.from.aigerim.rentcarskg.mapper;

import org.mapstruct.Mapper;
import project.from.aigerim.rentcarskg.entity.AddressEntity;
import project.from.aigerim.rentcarskg.entity.dto.AddressDto;

import java.util.List;

@Mapper
public interface AddressMapper {
    AddressEntity toEntity(AddressDto addressDto);

    AddressDto toDto(AddressEntity address);

    List<AddressDto> toDtoList(List<AddressEntity> addresses);
}
