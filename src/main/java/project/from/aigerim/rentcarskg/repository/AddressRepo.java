package project.from.aigerim.rentcarskg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.from.aigerim.rentcarskg.entity.AddressEntity;

import java.util.UUID;

@Repository
public interface AddressRepo extends JpaRepository<AddressEntity, UUID> {
}
