package at.ac.fhcampus.master.monolith.user.converters;

import at.ac.fhcampus.master.monolith.fixtures.UserFixture;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserDtoToEntityConverterTest {

    @Test
    void convert() {
        UserDtoToEntityConverter converter = new UserDtoToEntityConverter();
        assertThat(converter.convert(UserFixture.mockedUserDto()))
                .isEqualToComparingFieldByField(UserFixture.mockedUser());
    }
}
