package project.from.aigerim.rentcarskg.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.from.aigerim.rentcarskg.entity.AddressEntity;
import project.from.aigerim.rentcarskg.entity.dto.AddressDto;
import project.from.aigerim.rentcarskg.mapper.AddressMapper;
import project.from.aigerim.rentcarskg.repository.AddressRepo;
import project.from.aigerim.rentcarskg.service.AddressService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService {
    private final AddressRepo repository;
    private final AddressMapper mapper;

    @Override
    public AddressDto save(AddressDto addressDto) {
        AddressEntity address = mapper.toEntity(addressDto);
        AddressEntity addressSave = repository.save(address);
        return mapper.toDto(addressSave);
    }

    @Override
    public AddressDto findById(UUID id) {
        return mapper.toDto(repository.findById(id).get());
    }

    @Override
    public List<AddressDto> findAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public AddressDto update(AddressDto addressDto, UUID id) {
        Optional<AddressEntity> optionalEntity = repository.findById(id);
        if (!optionalEntity.isPresent()) {
            log.error("Can not find address by id: {}", id);
            return null;
        } else {
            AddressEntity update = optionalEntity.get();
            update.setStreet(addressDto.getStreet());
            update.setCity(addressDto.getCity());
            update.setBuildingNum(addressDto.getBuildingNum());
            AddressEntity saved = repository.save(update);
            return mapper.toDto(saved);
        }
    }

    @Override
    public void delete(UUID id) {
        AddressEntity address = repository.findById(id).get();
        repository.delete(address);
    }
}
