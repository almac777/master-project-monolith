package at.ac.fhcampus.master.monolith.ratings.controllers;

import at.ac.fhcampus.master.monolith.ratings.dtos.RatingDto;
import at.ac.fhcampus.master.monolith.ratings.entities.Rating;
import at.ac.fhcampus.master.monolith.ratings.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(RatingsController.BASE_URL)
public final class RatingsController {

    static final String BASE_URL = "/api/v1/ratings";
    private static final String RATE_URL = "/rate";

    private final RatingService ratingService;

    @PostMapping(RATE_URL)
    public RatingDto rate(@RequestBody RatingDto ratingDto) {
        return this.ratingService.rate(ratingDto);
    }
}
