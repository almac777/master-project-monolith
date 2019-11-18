package at.ac.fhcampus.master.monolith.articles.services;

import at.ac.fhcampus.master.monolith.articles.dtos.ArticleDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultArticleService implements ArticleService {

    @Override
    public ArticleDto register(ArticleDto articleDto) {
        throw new RuntimeException("not yet implemented");
    }

    @Override
    public List<ArticleDto> list() {
        throw new RuntimeException("not yet implemented");
    }

    @Override
    public ArticleDto show(Long id) {
        throw new RuntimeException("not yet implemented");
    }
}
