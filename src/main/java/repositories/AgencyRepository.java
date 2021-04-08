package repositories;

import domain.Agency;
import org.springframework.data.repository.CrudRepository;

public interface AgencyRepository extends CrudRepository<Agency, Long> {
}
