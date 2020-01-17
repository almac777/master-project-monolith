package at.ac.fhcampus.master.monolith.articles.services;

import at.ac.fhcampus.master.monolith.articles.converters.ArticleDtoToEntityConverter;
import at.ac.fhcampus.master.monolith.articles.converters.ArticleToDtoConverter;
import at.ac.fhcampus.master.monolith.articles.repositories.ArticleRepository;
import at.ac.fhcampus.master.monolith.fixtures.ArticleFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DefaultArticleServiceTest {

    private ArticleRepository articleRepository;
    private DefaultArticleService defaultArticleService;
    private ArticleDtoToEntityConverter articleDtoToEntityConverter;
    private ArticleToDtoConverter articleToDtoConverter;

    @BeforeEach
    void setup() {
        this.articleRepository = mock(ArticleRepository.class);
        this.articleDtoToEntityConverter = mock(ArticleDtoToEntityConverter.class);
        this.articleToDtoConverter = mock(ArticleToDtoConverter.class);
        this.defaultArticleService = new DefaultArticleService(
                this.articleRepository,
                this.articleDtoToEntityConverter,
                this.articleToDtoConverter
        );
    }

    @Test
    void register() {
        when(this.articleDtoToEntityConverter.convert(ArticleFixture.mockedArticleDto()))
                .thenReturn(ArticleFixture.mockedArticle());
        when(this.articleRepository.save(ArticleFixture.mockedArticle()))
                .thenReturn(ArticleFixture.mockedArticle());
        when(this.articleToDtoConverter.convert(ArticleFixture.mockedArticle()))
                .thenReturn(ArticleFixture.mockedArticleDto());

        assertThat(this.defaultArticleService.register(ArticleFixture.mockedArticleDto()))
                .isEqualToComparingFieldByField(ArticleFixture.mockedArticleDto());

        verify(this.articleDtoToEntityConverter, times(1))
                .convert(ArticleFixture.mockedArticleDto());
        verify(this.articleRepository, times(1))
                .save(ArticleFixture.mockedArticle());
        verify(this.articleToDtoConverter, times(1))
                .convert(ArticleFixture.mockedArticle());
    }

    @Test
    void list() {
        when(this.articleRepository.findAll()).thenReturn(List.of(ArticleFixture.mockedArticle()));
        when(this.articleToDtoConverter.convert(ArticleFixture.mockedArticle()))
                .thenReturn(ArticleFixture.mockedArticleDto());
        this.defaultArticleService.list();
        verify(this.articleRepository, times(1)).findAll();
    }

    @Test
    void show() {
        long id = 1L;
        when(this.articleRepository.findById(id)).thenReturn(ArticleFixture.optionalMockedArticle());
        when(this.articleToDtoConverter.convert(ArticleFixture.mockedArticle()))
                .thenReturn(ArticleFixture.mockedArticleDto());
        this.defaultArticleService.show(id);
        verify(this.articleRepository, times(1)).findById(id);
    }
}
