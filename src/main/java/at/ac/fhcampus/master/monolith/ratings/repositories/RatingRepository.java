package at.ac.fhcampus.master.monolith.ratings.repositories;

import at.ac.fhcampus.master.monolith.ratings.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
