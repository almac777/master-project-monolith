package at.ac.fhcampus.master.monolith.ratings.converter;

import at.ac.fhcampus.master.monolith.articles.converters.ArticleToDtoConverter;
import at.ac.fhcampus.master.monolith.articles.dtos.ArticleDto;
import at.ac.fhcampus.master.monolith.articles.entities.Article;
import at.ac.fhcampus.master.monolith.ratings.dtos.AccumulatedRatingDto;
import at.ac.fhcampus.master.monolith.ratings.entities.AccumulatedRating;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccumulatedRatingToDtoConverter implements Converter<AccumulatedRating, AccumulatedRatingDto> {

    @Override
    public AccumulatedRatingDto convert(AccumulatedRating source) {
        return AccumulatedRatingDto.builder()
                .id(source.getId())
                .completionRating(source.getCompletionRating())
                .objectivityRating(source.getObjectivityRating())
                .article(this.convertArticle(source.getArticle()))
                .build();
    }

    private ArticleDto convertArticle(Article article) {
        return new ArticleToDtoConverter().convert(article);
    }
}
