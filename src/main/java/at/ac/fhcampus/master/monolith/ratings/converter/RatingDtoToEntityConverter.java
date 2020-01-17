package at.ac.fhcampus.master.monolith.ratings.converter;

import at.ac.fhcampus.master.monolith.articles.converters.ArticleDtoToEntityConverter;
import at.ac.fhcampus.master.monolith.articles.dtos.ArticleDto;
import at.ac.fhcampus.master.monolith.articles.entities.Article;
import at.ac.fhcampus.master.monolith.auth.converters.UserDtoToEntityConverter;
import at.ac.fhcampus.master.monolith.auth.dtos.UserDto;
import at.ac.fhcampus.master.monolith.auth.entities.User;
import at.ac.fhcampus.master.monolith.ratings.dtos.RatingDto;
import at.ac.fhcampus.master.monolith.ratings.entities.Rating;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RatingDtoToEntityConverter implements Converter<RatingDto, Rating> {
    @Override
    public Rating convert(RatingDto source) {
        return Rating.builder()
                .id(source.getId())
                .objectivityRating(source.getObjectivityRating())
                .completionRating(source.getCompletionRating())
                .article(this.convertArticle(source.getArticle()))
                .user(this.convertUser(source.getUser()))
                .build();
    }

    private Article convertArticle(@NonNull ArticleDto article) {
        return new ArticleDtoToEntityConverter().convert(article);
    }

    private User convertUser(@NonNull UserDto userDto) {
        return new UserDtoToEntityConverter().convert(userDto);
    }
}
