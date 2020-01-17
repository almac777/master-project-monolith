package at.ac.fhcampus.master.monolith.articles.converters;

import at.ac.fhcampus.master.monolith.fixtures.ArticleFixture;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ArticleToDtoConverterTest {

    @Test
    void convert() {
        var articleToDtoConverter = new ArticleToDtoConverter();
        assertThat(articleToDtoConverter.convert(ArticleFixture.mockedArticle()))
                .isEqualToComparingFieldByField(ArticleFixture.mockedArticleDto());
    }
}
