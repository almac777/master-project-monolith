package at.ac.fhcampus.master.monolith.articles.converters;

import at.ac.fhcampus.master.monolith.fixtures.ArticleFixture;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ArticleDtoToEntityConverterTest {

    @Test
    void convert() {
        ArticleDtoToEntityConverter articleDtoToEntityConverter = new ArticleDtoToEntityConverter();
        assertThat(articleDtoToEntityConverter.convert(ArticleFixture.mockedArticleDto()))
                .isEqualToComparingFieldByField(ArticleFixture.mockedArticle());
    }
}
