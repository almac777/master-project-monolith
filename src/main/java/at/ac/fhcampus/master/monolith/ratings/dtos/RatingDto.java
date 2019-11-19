package at.ac.fhcampus.master.monolith.ratings.dtos;

import at.ac.fhcampus.master.monolith.articles.dtos.ArticleDto;
import at.ac.fhcampus.master.monolith.auth.dtos.UserDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RatingDto {

    private Long id;
    private Long objectivityRating;
    private Long completionRating;
    private UserDto user;
    private ArticleDto article;

}
