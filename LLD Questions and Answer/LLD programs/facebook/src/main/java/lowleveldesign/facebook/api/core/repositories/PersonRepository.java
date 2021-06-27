package lowleveldesign.facebook.api.core.repositories;

import lowleveldesign.facebook.api.core.entities.Person;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends CassandraRepository<Person, UUID> {
}
