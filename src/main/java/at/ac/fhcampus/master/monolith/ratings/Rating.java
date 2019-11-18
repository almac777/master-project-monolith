package at.ac.fhcampus.master.monolith.ratings;

import at.ac.fhcampus.master.monolith.articles.entities.Article;
import at.ac.fhcampus.master.monolith.auth.entities.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Table(name = "article_ratings")
@Entity
public class Rating {

    @Id @GeneratedValue private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

}
