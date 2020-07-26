package at.ac.fhcampus.master.monolith.ratings.services;

import at.ac.fhcampus.master.monolith.articles.dtos.ArticleDto;
import at.ac.fhcampus.master.monolith.user.dtos.UserDto;
import at.ac.fhcampus.master.monolith.ratings.converter.RatingDtoToEntityConverter;
import at.ac.fhcampus.master.monolith.ratings.converter.RatingToDtoConverter;
import at.ac.fhcampus.master.monolith.ratings.dtos.RatingDto;
import at.ac.fhcampus.master.monolith.ratings.entities.Rating;
import at.ac.fhcampus.master.monolith.ratings.repositories.RatingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultRatingService implements RatingService {

    private final AccumulatedRatingService accumulatedRatingService;

    private final RatingRepository ratingRepository;
    private final RatingToDtoConverter ratingToDtoConverter;
    private final RatingDtoToEntityConverter ratingDtoToEntityConverter;

    @Override
    public List<RatingDto> byArticle(ArticleDto articleDto) {
        return Optional.of(articleDto)
                .map(article -> ratingRepository.findByArticleId(articleDto.getId()))
                .orElse(new LinkedList<>())
                .stream()
                .map(ratingToDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<RatingDto> byUser(UserDto userDto) {
        return Optional.of(userDto)
                .map(article -> ratingRepository.findByUserId(userDto.getId()))
                .orElse(new LinkedList<>())
                .stream()
                .map(ratingToDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public RatingDto rate(RatingDto ratingDto) {
        return Optional.of(ratingDto)
                .map(ratingDtoToEntityConverter::convert)
                .map(this::peekRating)
                .map(ratingRepository::save)
                .map(this::calculateRating)
                .map(ratingToDtoConverter::convert)
                .orElseThrow(() -> new RuntimeException("Rating has not been saved"));
    }

    public Rating calculateRating(Rating rate) {
        return Optional.of(rate)
                .map(accumulatedRatingService::addRating)
                .map(accumulatedRating -> rate)
                .orElse(null);
    }

    public Rating peekRating(Rating in) {
        log.info("{}", in);
        return in;
    }

    @Override
    public List<RatingDto> list() {
        return this.ratingRepository.findAll()
                .stream()
                .map(ratingToDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public RatingDto update(Long id, RatingDto ratingDto) {
        var oldRating = this.ratingRepository.findById(id).orElseThrow(() -> new RuntimeException("Rating has not been found"));
        oldRating.setCompletionRating(ratingDto.getCompletionRating());
        oldRating.setObjectivityRating(ratingDto.getObjectivityRating());
        return Optional.of(ratingRepository.save(oldRating))
                .map(ratingToDtoConverter::convert)
                .orElseThrow(() -> new RuntimeException("Rating has not been updated"));
    }

    @Override
    public void delete(Long id) {
        var rating = ratingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rating has not been found"));
        ratingRepository.delete(rating);
    }
}
