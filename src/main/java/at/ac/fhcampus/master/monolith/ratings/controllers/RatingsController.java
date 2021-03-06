package at.ac.fhcampus.master.monolith.ratings.controllers;

import at.ac.fhcampus.master.monolith.articles.dtos.ArticleDto;
import at.ac.fhcampus.master.monolith.ratings.dtos.AccumulatedRatingDto;
import at.ac.fhcampus.master.monolith.ratings.dtos.RatingDto;
import at.ac.fhcampus.master.monolith.ratings.services.AccumulatedRatingService;
import at.ac.fhcampus.master.monolith.ratings.services.RatingService;
import at.ac.fhcampus.master.monolith.user.dtos.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(RatingsController.BASE_URL)
public final class RatingsController {

    static final String BASE_URL = "/api/v1/ratings";

    private static final String ROOT_URL = "/";
    private static final String ID_URL = "/{id}";
    private static final String ARTICLE_RATE_URL = "/by-article/{id}";
    private static final String ACCUMULATED_URL = "/accumulated/{id}";
    private static final String USER_RATE_URL = "/by-user/{id}";

    private final RatingService ratingService;
    private final AccumulatedRatingService accumulatedService;


    @GetMapping(ARTICLE_RATE_URL)
    public List<RatingDto> byArticle(@PathVariable("id") Long id) {
        return this.ratingService.byArticle(ArticleDto.builder().id(id).build());
    }

    @GetMapping(USER_RATE_URL)
    public List<RatingDto> byUser(@PathVariable("id") Long id) {
        return this.ratingService.byUser(UserDto.builder().id(id).build());
    }

    @GetMapping(ACCUMULATED_URL)
    public AccumulatedRatingDto accumulated(@PathVariable("id") Long id) {
        return this.accumulatedService.showAccumulatedRatingForArticleWithId(id);
    }

    @PostMapping(ROOT_URL)
    public RatingDto rate(@RequestBody RatingDto ratingDto) {
        return this.ratingService.rate(ratingDto);
    }

    @PutMapping(ID_URL)
    @PatchMapping(ID_URL)
    public RatingDto update(@PathVariable("id") Long id, @RequestBody RatingDto ratingDto) {
        return this.ratingService.update(id, ratingDto);
    }

    @DeleteMapping(ID_URL)
    public void delete(@PathVariable("id") Long id) {
        this.ratingService.delete(id);
    }
}
