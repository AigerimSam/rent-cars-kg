package project.from.aigerim.rentcarskg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.from.aigerim.rentcarskg.entity.OrderEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
    List<OrderEntity> findByCarId(UUID id);


}
