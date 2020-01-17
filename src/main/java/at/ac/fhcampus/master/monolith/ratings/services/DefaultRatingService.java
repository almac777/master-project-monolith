package at.ac.fhcampus.master.monolith.ratings.services;

import at.ac.fhcampus.master.monolith.ratings.converter.RatingDtoToEntityConverter;
import at.ac.fhcampus.master.monolith.ratings.converter.RatingToDtoConverter;
import at.ac.fhcampus.master.monolith.ratings.dtos.RatingDto;
import at.ac.fhcampus.master.monolith.ratings.repositories.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultRatingService implements RatingService {

    private final RatingRepository ratingRepository;
    private final RatingToDtoConverter ratingToDtoConverter;
    private final RatingDtoToEntityConverter ratingDtoToEntityConverter;

    @Override
    public RatingDto rate(RatingDto ratingDto) {
        return Optional.of(ratingDto)
                .map(ratingDtoToEntityConverter::convert)
                .map(ratingRepository::save)
                .map(ratingToDtoConverter::convert)
                .orElseThrow(() -> new RuntimeException("Rating has not been saved"));
    }

}
