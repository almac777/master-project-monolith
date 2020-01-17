package at.ac.fhcampus.master.monolith.ratings.services;

import at.ac.fhcampus.master.monolith.fixtures.RatingFixture;
import at.ac.fhcampus.master.monolith.ratings.converter.RatingDtoToEntityConverter;
import at.ac.fhcampus.master.monolith.ratings.converter.RatingToDtoConverter;
import at.ac.fhcampus.master.monolith.ratings.repositories.RatingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DefaultRatingServiceTest {

    private DefaultRatingService ratingService;
    private RatingRepository ratingRepository;
    private RatingToDtoConverter ratingToDtoConverter;
    private RatingDtoToEntityConverter ratingDtoToEntityConverter;

    @BeforeEach
    void setup() {
        this.ratingRepository = mock(RatingRepository.class);
        this.ratingToDtoConverter = mock(RatingToDtoConverter.class);
        this.ratingDtoToEntityConverter = mock(RatingDtoToEntityConverter.class);
        this.ratingService = new DefaultRatingService(
                ratingRepository,
                ratingToDtoConverter,
                ratingDtoToEntityConverter
        );

    }

    @Test
    void rate() {
        when(ratingToDtoConverter.convert(RatingFixture.mockRating())).thenReturn(RatingFixture.mockRatingDto());
        when(ratingRepository.save(RatingFixture.mockRating())).thenReturn(RatingFixture.mockRating());
        when(ratingDtoToEntityConverter.convert(RatingFixture.mockRatingDto())).thenReturn(RatingFixture.mockRating());

        this.ratingService.rate(RatingFixture.mockRatingDto());

        verify(ratingToDtoConverter, times(1)).convert(RatingFixture.mockRating());
        verify(ratingRepository, times(1)).save(RatingFixture.mockRating());
        verify(ratingDtoToEntityConverter, times(1)).convert(RatingFixture.mockRatingDto());
    }
}
