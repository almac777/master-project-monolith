package at.ac.fhcampus.master.monolith.articles.services;

import at.ac.fhcampus.master.monolith.articles.converters.ArticleDtoToEntityConverter;
import at.ac.fhcampus.master.monolith.articles.converters.ArticleToDtoConverter;
import at.ac.fhcampus.master.monolith.articles.dtos.ArticleDto;
import at.ac.fhcampus.master.monolith.articles.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultArticleService implements ArticleService {

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
                .orElseThrow(() -> new RuntimeException(String.format("Article with id %d has not been found", id)));
    }

}
