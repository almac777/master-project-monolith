package at.ac.fhcampus.master.monolith.fixtures;

import at.ac.fhcampus.master.monolith.articles.dtos.ArticleDto;
import at.ac.fhcampus.master.monolith.articles.entities.Article;

import java.util.Optional;

public class ArticleFixture {
    public static ArticleDto mockedArticleDto() {
        return ArticleDto.builder()
                .id(1L)
                .url("https://www.diepresse.com/5723511/im-silicon-valley-sind-mitarbeiter-luxus")
                .build();
    }

    public static Article mockedArticle() {
        return Article.builder()
                .id(1L)
                .url("https://www.diepresse.com/5723511/im-silicon-valley-sind-mitarbeiter-luxus")
                .build();
    }

    public static Optional<Article> optionalMockedArticle() {
        return Optional.of(mockedArticle());
    }
}
