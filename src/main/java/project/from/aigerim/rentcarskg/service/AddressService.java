package project.from.aigerim.rentcarskg.service;

import project.from.aigerim.rentcarskg.entity.dto.AddressDto;

import java.util.List;
import java.util.UUID;

public interface AddressService {
    AddressDto save(AddressDto addressDto);

    AddressDto findById(UUID id);

    List<AddressDto> findAll();

    AddressDto update(AddressDto addressDto, UUID id);

    void delete(UUID id);
}

