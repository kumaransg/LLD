package lowleveldesign.uber.api.repositories;

import lowleveldesign.uber.api.core.entities.Driver;
import lowleveldesign.uber.api.core.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {
    Optional<Driver> findFirstByUser_MobileNumber(String mobileNumber);
}
