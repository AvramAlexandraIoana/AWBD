package repositories;

import domain.Tourist;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TouristRepository extends PagingAndSortingRepository<Tourist, Long> {
}
