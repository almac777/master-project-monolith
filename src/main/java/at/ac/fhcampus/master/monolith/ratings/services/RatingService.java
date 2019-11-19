package at.ac.fhcampus.master.monolith.ratings.services;

import at.ac.fhcampus.master.monolith.ratings.dtos.RatingDto;

public interface RatingService {
    RatingDto rate(RatingDto ratingDto);
}
