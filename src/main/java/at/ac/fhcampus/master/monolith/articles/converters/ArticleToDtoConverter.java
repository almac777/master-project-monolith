package at.ac.fhcampus.master.monolith.articles.converters;

import at.ac.fhcampus.master.monolith.articles.dtos.ArticleDto;
import at.ac.fhcampus.master.monolith.articles.entities.Article;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ArticleToDtoConverter implements Converter<Article, ArticleDto> {
    @Override
    public ArticleDto convert(Article source) {
        return ArticleDto.builder()
                .id(source.getId())
                .url(source.getUrl())
                .build();
    }

}
