package project.from.aigerim.rentcarskg.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project.from.aigerim.rentcarskg.entity.dto.AddressDto;
import project.from.aigerim.rentcarskg.service.AddressService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
@Validated
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    @ApiOperation("Create address")
    public AddressDto save(@Valid @RequestBody AddressDto addressDto) {
        return addressService.save(addressDto);
    }

    @GetMapping("/{id}")
    @ApiOperation("Find address by id")
    public AddressDto findById(@PathVariable("id") UUID id) {
        return addressService.findById(id);
    }

    @GetMapping
    @ApiOperation("Find all address")
    public List<AddressDto> findAll() {
        return addressService.findAll();
    }

    @PutMapping("/{id}")
    @ApiOperation("Update address by id")
    public AddressDto update(@PathVariable("id") UUID id, @Valid @RequestBody AddressDto addressDto) {
        addressDto.setId(id);
        return addressService.update(addressDto, id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete address by id")
    public void delete(@PathVariable("id") UUID id) {
        addressService.delete(id);
    }
}
