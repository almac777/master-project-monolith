package at.ac.fhcampus.master.monolith.ratings.repositories;

import at.ac.fhcampus.master.monolith.ratings.entities.AccumulatedRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccumulatedRatingRepository extends JpaRepository<AccumulatedRating, Long> {
    @Query("FROM AccumulatedRating ar WHERE ar.article.id = :articleId")
    Optional<AccumulatedRating> findByArticleId(@Param("articleId") Long articleId);
}
