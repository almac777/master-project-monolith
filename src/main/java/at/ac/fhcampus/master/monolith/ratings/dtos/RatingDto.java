package at.ac.fhcampus.master.monolith.ratings.dtos;

import at.ac.fhcampus.master.monolith.articles.dtos.ArticleDto;
import at.ac.fhcampus.master.monolith.auth.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {

    private Long id;
    private Long objectivityRating;
    private Long completionRating;
    private UserDto user;
    private ArticleDto article;

}
