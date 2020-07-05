package at.ac.fhcampus.master.monolith.articles.services;

import at.ac.fhcampus.master.monolith.articles.dtos.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto register(ArticleDto articleDto);

    List<ArticleDto> list();

    ArticleDto show(Long id);

    ArticleDto update(Long id, ArticleDto articleDto);

    public void delete(Long id);
}
