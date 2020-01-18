package at.ac.fhcampus.master.monolith.ratings.services;

import at.ac.fhcampus.master.monolith.fixtures.AccumulatedRatingFixture;
import at.ac.fhcampus.master.monolith.fixtures.ArticleFixture;
import at.ac.fhcampus.master.monolith.fixtures.RatingFixture;
import at.ac.fhcampus.master.monolith.fixtures.UserFixture;
import at.ac.fhcampus.master.monolith.ratings.converter.RatingDtoToEntityConverter;
import at.ac.fhcampus.master.monolith.ratings.converter.RatingToDtoConverter;
import at.ac.fhcampus.master.monolith.ratings.entities.AccumulatedRating;
import at.ac.fhcampus.master.monolith.ratings.repositories.RatingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DefaultRatingServiceTest {

    private DefaultRatingService ratingService;
    private RatingRepository ratingRepository;
    private RatingToDtoConverter ratingToDtoConverter;
    private AccumulatedRatingService accumulatedRatingService;
    private RatingDtoToEntityConverter ratingDtoToEntityConverter;

    @BeforeEach
    void setup() {
        this.ratingRepository = mock(RatingRepository.class);
        this.ratingToDtoConverter = mock(RatingToDtoConverter.class);
        this.accumulatedRatingService = mock(AccumulatedRatingService.class);
        this.ratingDtoToEntityConverter = mock(RatingDtoToEntityConverter.class);
        this.ratingService = new DefaultRatingService(
                accumulatedRatingService,
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
        when(accumulatedRatingService.addRating(any())).thenReturn(AccumulatedRatingFixture.mockAccumulatedRating());

        this.ratingService.rate(RatingFixture.mockRatingDto());

        verify(ratingToDtoConverter, times(1)).convert(RatingFixture.mockRating());
        verify(ratingRepository, times(1)).save(RatingFixture.mockRating());
        verify(ratingDtoToEntityConverter, times(1)).convert(RatingFixture.mockRatingDto());
    }

    @Test
    void byArticle() {
        when(ratingToDtoConverter.convert(any())).thenReturn(RatingFixture.mockRatingDto());
        when(ratingRepository.findByArticleId(any())).thenReturn(List.of(RatingFixture.mockRating()));
        when(ratingDtoToEntityConverter.convert(any())).thenReturn(RatingFixture.mockRating());

        this.ratingService.byArticle(ArticleFixture.mockedArticleDto());

        verify(ratingToDtoConverter, atMostOnce()).convert(RatingFixture.mockRating());
        verify(ratingRepository, atMostOnce()).save(RatingFixture.mockRating());
        verify(ratingDtoToEntityConverter, atMostOnce()).convert(RatingFixture.mockRatingDto());
    }

    @Test
    void byArticle_articleNotFound() {
        when(ratingRepository.findByArticleId(any())).thenReturn(List.of());
        assertThat(this.ratingService.byArticle(ArticleFixture.mockedArticleDto()))
                .isEmpty();
    }

    @Test
    void byUser() {
        when(ratingToDtoConverter.convert(any())).thenReturn(RatingFixture.mockRatingDto());
        when(ratingRepository.findByUserId(any())).thenReturn(List.of(RatingFixture.mockRating()));
        when(ratingDtoToEntityConverter.convert(any())).thenReturn(RatingFixture.mockRating());

        this.ratingService.byUser(UserFixture.mockedUserDto());

        verify(ratingToDtoConverter, atMostOnce()).convert(RatingFixture.mockRating());
        verify(ratingRepository, atMostOnce()).save(RatingFixture.mockRating());
        verify(ratingDtoToEntityConverter, atMostOnce()).convert(RatingFixture.mockRatingDto());
    }

    @Test
    void byUser_userNotFound() {
        when(ratingRepository.findByUserId(any())).thenReturn(List.of());
        assertThat(this.ratingService.byUser(UserFixture.mockedUserDto()))
                .isEmpty();
    }
}
