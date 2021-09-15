package lowleveldesign.uber.api.repositories;

import lowleveldesign.uber.api.core.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findFirstByUser_MobileNumber(String mobileNumber);
}
