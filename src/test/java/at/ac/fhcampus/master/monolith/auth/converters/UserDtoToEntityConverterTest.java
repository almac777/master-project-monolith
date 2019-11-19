package at.ac.fhcampus.master.monolith.auth.converters;

import at.ac.fhcampus.master.monolith.fixtures.UserFixture;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserDtoToEntityConverterTest {

    @Test
    void convert() {
        UserDtoToEntityConverter converter = new UserDtoToEntityConverter();
        assertThat(converter.convert(UserFixture.mockedUserDto()))
                .isEqualToComparingFieldByField(UserFixture.mockedUser());
    }
}
