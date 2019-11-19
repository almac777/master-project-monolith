package at.ac.fhcampus.master.monolith.articles.converters;

import at.ac.fhcampus.master.monolith.articles.dtos.ArticleDto;
import at.ac.fhcampus.master.monolith.articles.entities.Article;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ArticleDtoToEntityConverter implements Converter<ArticleDto, Article> {
    @Override
    public Article convert(ArticleDto source) {
        return Article.builder()
                .id(source.getId())
                .url(source.getUrl())
                // @todo: Expand upon this
                .build();
    }
}
