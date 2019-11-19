package at.ac.fhcampus.master.monolith.ratings.converter;

import at.ac.fhcampus.master.monolith.fixtures.RatingFixture;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RatingToDtoConverterTest {

    @Test
    void convert() {
        var converter = new RatingToDtoConverter();
        assertThat(converter.convert(RatingFixture.mockRating()))
                .isEqualToComparingFieldByField(RatingFixture.mockRatingDto());
    }
}
