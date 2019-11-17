package at.ac.fhcampus.master.monolith.ratings.services;

import at.ac.fhcampus.master.monolith.ratings.RatingDto;

public interface RatingService {
    void rate(RatingDto ratingDto);
}
