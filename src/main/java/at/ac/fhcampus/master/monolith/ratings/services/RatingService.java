package at.ac.fhcampus.master.monolith.ratings.services;

import at.ac.fhcampus.master.monolith.articles.dtos.ArticleDto;
import at.ac.fhcampus.master.monolith.auth.dtos.UserDto;
import at.ac.fhcampus.master.monolith.ratings.dtos.RatingDto;

import java.util.List;

public interface RatingService {
    List<RatingDto> byArticle(ArticleDto articleDto);
    List<RatingDto> byUser(UserDto userDto);
    RatingDto rate(RatingDto ratingDto);
    List<RatingDto> list();
}
