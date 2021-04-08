package repositories;

import domain.Country;
import domain.Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<Info, Long>  {
}
