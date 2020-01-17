package at.ac.fhcampus.master.monolith.fixtures;

import at.ac.fhcampus.master.monolith.ratings.entities.AccumulatedRating;

public class AccumulatedRatingFixture {
    public static AccumulatedRating mockAccumulatedRating() {
        return AccumulatedRating.builder()
                .id(1L)
                .article(ArticleFixture.mockedArticle())
                .completionRating(10.0)
                .objectivityRating(10.0)
                .build();
    }
}
