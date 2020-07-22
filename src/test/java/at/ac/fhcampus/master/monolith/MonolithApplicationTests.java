package at.ac.fhcampus.master.monolith;

import at.ac.fhcampus.master.monolith.articles.controllers.ArticleController;
import at.ac.fhcampus.master.monolith.articles.repositories.ArticleRepository;
import at.ac.fhcampus.master.monolith.user.controllers.RegistrationController;
import at.ac.fhcampus.master.monolith.user.repositories.AuthorityRepository;
import at.ac.fhcampus.master.monolith.user.repositories.UserRepository;
import at.ac.fhcampus.master.monolith.ratings.controllers.RatingsController;
import at.ac.fhcampus.master.monolith.ratings.repositories.RatingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
class MonolithApplicationTests {

    @Autowired
    private ArticleController articleController;
    @Autowired
    private RatingsController ratingsController;
    @Autowired
    private RegistrationController registrationController;

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthorityRepository authorityRepository;

    @Test
    void contextLoads() {
        assertThat(articleController).isNotNull();
        assertThat(ratingsController).isNotNull();
        assertThat(registrationController).isNotNull();

        assertThat(articleRepository).isNotNull();
        assertThat(ratingRepository).isNotNull();
        assertThat(userRepository).isNotNull();
        assertThat(authorityRepository).isNotNull();
    }
}
