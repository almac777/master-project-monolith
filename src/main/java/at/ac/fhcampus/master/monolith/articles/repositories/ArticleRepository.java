package at.ac.fhcampus.master.monolith.articles.repositories;

import at.ac.fhcampus.master.monolith.articles.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Long, Article> {
}
