package at.ac.fhcampus.master.monolith.ratings.dtos;

import at.ac.fhcampus.master.monolith.articles.dtos.ArticleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccumulatedRatingDto {
    private Long id;
    private Double objectivityRating;
    private Double completionRating;
    private ArticleDto article;
}
