package at.ac.fhcampus.master.monolith.fixtures;

import at.ac.fhcampus.master.monolith.ratings.dtos.RatingDto;
import at.ac.fhcampus.master.monolith.ratings.entities.Rating;

public class RatingFixture {

    public static Rating mockRating() {
        return Rating.builder()
                .id(1L)
                .objectivityRating(5L)
                .completionRating(5L)
                .article(ArticleFixture.mockedArticle())
                .user(UserFixture.mockedUser())
                .build();
    }

    public static RatingDto mockRatingDto() {
        return RatingDto.builder()
                .id(1L)
                .objectivityRating(5L)
                .completionRating(5L)
                .article(ArticleFixture.mockedArticleDto())
                .user(UserFixture.mockedUserDto())
                .build();
    }

}
