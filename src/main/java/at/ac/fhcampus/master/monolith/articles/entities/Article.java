package at.ac.fhcampus.master.monolith.articles.entities;

import at.ac.fhcampus.master.monolith.ratings.entities.AccumulatedRating;
import at.ac.fhcampus.master.monolith.ratings.entities.Rating;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@Table(name = "articles")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    @OneToMany(mappedBy = "article")
    private List<Rating> ratings;

    @OneToOne(mappedBy = "article")
    private AccumulatedRating accumulatedRating;
}
