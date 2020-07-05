package at.ac.fhcampus.master.monolith.articles.services;

import at.ac.fhcampus.master.monolith.articles.converters.ArticleDtoToEntityConverter;
import at.ac.fhcampus.master.monolith.articles.converters.ArticleToDtoConverter;
import at.ac.fhcampus.master.monolith.articles.dtos.ArticleDto;
import at.ac.fhcampus.master.monolith.articles.entities.Article;
import at.ac.fhcampus.master.monolith.articles.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultArticleService implements ArticleService {

    public static final String ARTICLE_WITH_ID_D_HAS_NOT_BEEN_FOUND = "Article with id %d has not been found";

    private final ArticleRepository articleRepository;
    private final ArticleDtoToEntityConverter articleDtoToEntityConverter;
    private final ArticleToDtoConverter articleToDtoConverter;

    @Override
    public ArticleDto register(ArticleDto articleDto) {
        return Optional.of(articleDto)
                .map(articleDtoToEntityConverter::convert)
                .map(articleRepository::save)
                .map(articleToDtoConverter::convert)
                .orElseThrow(() -> new RuntimeException("Article has not been stored"));
    }

    @Override
    public List<ArticleDto> list() {
        return this.articleRepository.findAll()
                .stream()
                .map(articleToDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public ArticleDto show(Long id) {
        return this.articleRepository.findById(id)
                .map(articleToDtoConverter::convert)
                .orElseThrow(() -> new RuntimeException(String.format(ARTICLE_WITH_ID_D_HAS_NOT_BEEN_FOUND, id)));
    }

    @Override
    public ArticleDto update(Long id, ArticleDto articleDto) {
        return this.articleRepository.findById(id)
                .map(oldArticle -> this.merge(oldArticle, articleDto))
                .map(articleRepository::save)
                .map(articleToDtoConverter::convert)
                .orElseThrow(() -> new RuntimeException(String.format(ARTICLE_WITH_ID_D_HAS_NOT_BEEN_FOUND, id)));
    }

    @Override
    public void delete(Long id) {
        var ret = this.articleRepository.findById(id)
                .map(input -> {
                    articleRepository.delete(input);
                    return input;
                })
                .orElseThrow(() -> new RuntimeException(String.format(ARTICLE_WITH_ID_D_HAS_NOT_BEEN_FOUND, id)));
        log.debug("article with id {} has been deleted / {}", id, ret);
    }

    private Article merge(Article oldArticle, ArticleDto articleDto) {
        oldArticle.setUrl(articleDto.getUrl());
        return oldArticle;
    }
}
