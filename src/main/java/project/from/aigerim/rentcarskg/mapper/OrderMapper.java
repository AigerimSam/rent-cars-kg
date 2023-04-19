package project.from.aigerim.rentcarskg.mapper;

import org.aspectj.weaver.ast.Or;
import org.mapstruct.Mapper;
import project.from.aigerim.rentcarskg.entity.OrderEntity;
import project.from.aigerim.rentcarskg.entity.dto.OrderDto;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderEntity toEntity(OrderDto orderDto);

    OrderDto toDto(OrderEntity orderEntity);

    List<OrderDto> toDtoLIst(List<OrderEntity> entities);
}
