package at.ac.fhcampus.master.monolith.ratings.entities;

import at.ac.fhcampus.master.monolith.articles.entities.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Table(name = "accumulated_ratings")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccumulatedRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double objectivityRating;
    private Double completionRating;

    @OneToOne
    @JoinColumn(name = "article_id")
    private Article article;
}
