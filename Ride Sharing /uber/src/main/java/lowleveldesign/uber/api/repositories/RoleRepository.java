package lowleveldesign.uber.api.repositories;

import lowleveldesign.uber.api.core.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findFirstByName(String name);
}
