package at.ac.fhcampus.master.monolith.ratings.services;

import at.ac.fhcampus.master.monolith.articles.entities.Article;
import at.ac.fhcampus.master.monolith.ratings.converter.AccumulatedRatingToDtoConverter;
import at.ac.fhcampus.master.monolith.ratings.dtos.AccumulatedRatingDto;
import at.ac.fhcampus.master.monolith.ratings.entities.AccumulatedRating;
import at.ac.fhcampus.master.monolith.ratings.entities.Rating;
import at.ac.fhcampus.master.monolith.ratings.repositories.AccumulatedRatingRepository;
import at.ac.fhcampus.master.monolith.ratings.repositories.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccumulatedRatingService {

    private final AccumulatedRatingToDtoConverter converter;
    private final AccumulatedRatingRepository accumulatedRatingRepository;
    private final RatingRepository ratingRepository;

    public List<AccumulatedRating> accumulateRatingsFor(List<Article> articles) {
        return articles.stream()
                .map(this::resetAccumulatedRating)
                .map(this::accumulateRatingFor)
                .collect(Collectors.toList());
    }

    private Article resetAccumulatedRating(Article article) {
        if (article.getAccumulatedRating() != null) {
            var accumulatedRating = article.getAccumulatedRating();
            accumulatedRating.setObjectivityRating(.0);
            accumulatedRating.setCompletionRating(.0);
            accumulatedRating = this.accumulatedRatingRepository.save(accumulatedRating);
            article.setAccumulatedRating(accumulatedRating);
        }
        return article;
    }

    public AccumulatedRating accumulateRatingFor(Article article) {
        var accRating = article.getRatings().stream()
                .map(this::addRating)
                .collect(Collectors.toList())
                .stream()
                .reduce((first, second) -> second)
                .orElseThrow(() -> new RuntimeException("Unexpected error occured"));
        accRating = accumulatedRatingRepository.save(accRating);
        article.setAccumulatedRating(accRating);
        return accRating;
    }

    public AccumulatedRating addRating(Rating rating) {
        var article = rating.getArticle();
        if (article == null) {
            throw new RuntimeException("Unexpected error occurred");
        }
        var accumulatedRating = accumulatedRatingRepository.findByArticleId(article.getId()).orElse(null);
        if (accumulatedRating == null) {
            accumulatedRating = AccumulatedRating.builder()
                    .article(article)
                    .completionRating(Double.valueOf(rating.getCompletionRating()))
                    .objectivityRating(Double.valueOf(rating.getObjectivityRating()))
                    .build();
        } else {
            Long amount = this.ratingRepository.countAllByArticle(article);
            amount++;
            Double newCompletionRating = (accumulatedRating.getCompletionRating() + rating.getCompletionRating())
                    / amount;
            Double newObjectivityRating = (accumulatedRating.getObjectivityRating() + rating.getObjectivityRating())
                    / amount;
            accumulatedRating.setCompletionRating(newCompletionRating);
            accumulatedRating.setObjectivityRating(newObjectivityRating);
        }
        return accumulatedRatingRepository.save(accumulatedRating);
    }

    public AccumulatedRatingDto showAccumulatedRatingForArticleWithId(Long articleId) {
        return this.accumulatedRatingRepository.findByArticleId(articleId)
                .map(converter::convert)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Article ID %d not found", articleId)
                ));
    }
}
