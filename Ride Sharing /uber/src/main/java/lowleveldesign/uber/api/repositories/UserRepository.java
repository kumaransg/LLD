package lowleveldesign.uber.api.repositories;

import lowleveldesign.uber.api.core.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByMobileNumber(String mobileNumber);
}
