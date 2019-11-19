package at.ac.fhcampus.master.monolith.ratings.entities;

import at.ac.fhcampus.master.monolith.articles.entities.Article;
import at.ac.fhcampus.master.monolith.auth.entities.User;
import lombok.Builder;
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
@Builder
public class Rating {

    @Id @GeneratedValue
    private Long id;

    private Long objectivityRating;
    private Long completionRating;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

}
