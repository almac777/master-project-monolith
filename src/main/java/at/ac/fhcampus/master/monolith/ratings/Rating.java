package at.ac.fhcampus.master.monolith.ratings;

import at.ac.fhcampus.master.monolith.articles.entities.Article;
import at.ac.fhcampus.master.monolith.auth.entities.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "article_ratings")
@Entity
public class Rating {

    @Id @GeneratedValue private Long id;

    private User user;
    private Article article;

}
