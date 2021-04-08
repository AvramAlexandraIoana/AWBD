package repositories;

import domain.Trip;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TripRepository extends PagingAndSortingRepository<Trip, Long> {
}
