package at.ac.fhcampus.master.monolith.articles.services;

import at.ac.fhcampus.master.monolith.articles.dtos.ArticleDto;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    ArticleDto register(ArticleDto articleDto);

    List<ArticleDto> list();

    ArticleDto show(Long id);
}
