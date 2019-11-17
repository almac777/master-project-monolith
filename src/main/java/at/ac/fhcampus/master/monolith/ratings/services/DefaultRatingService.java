package at.ac.fhcampus.master.monolith.ratings.services;

import at.ac.fhcampus.master.monolith.ratings.RatingDto;

public class DefaultRatingService implements RatingService {
    @Override
    public void rate(RatingDto ratingDto) {
        throw new RuntimeException("not yet implemented");
    }
}
