package at.ac.fhcampus.master.monolith.ratings.converter;

import at.ac.fhcampus.master.monolith.articles.converters.ArticleToDtoConverter;
import at.ac.fhcampus.master.monolith.articles.dtos.ArticleDto;
import at.ac.fhcampus.master.monolith.articles.entities.Article;
import at.ac.fhcampus.master.monolith.user.converters.UserToDtoConverter;
import at.ac.fhcampus.master.monolith.user.dtos.UserDto;
import at.ac.fhcampus.master.monolith.user.entities.User;
import at.ac.fhcampus.master.monolith.ratings.dtos.RatingDto;
import at.ac.fhcampus.master.monolith.ratings.entities.Rating;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RatingToDtoConverter implements Converter<Rating, RatingDto> {

    @Override
    public RatingDto convert(Rating source) {
        return RatingDto.builder()
                .id(source.getId())
                .completionRating(source.getCompletionRating())
                .objectivityRating(source.getObjectivityRating())
                .article(this.convertArticle(source.getArticle()))
                .user(this.convertUser(source.getUser()))
                .build();
    }

    private ArticleDto convertArticle(Article source) {
        return new ArticleToDtoConverter().convert(source);
    }

    private UserDto convertUser(User user) {
        return new UserToDtoConverter().convert(user);
    }
}
