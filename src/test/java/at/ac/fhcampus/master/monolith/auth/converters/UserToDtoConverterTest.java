package at.ac.fhcampus.master.monolith.auth.converters;

import at.ac.fhcampus.master.monolith.fixtures.UserFixture;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserToDtoConverterTest {

    @Test
    void convert() {
        UserToDtoConverter userToDtoConverter = new UserToDtoConverter();
        assertThat(userToDtoConverter.convert(UserFixture.mockedUser()))
                .isEqualToComparingFieldByField(UserFixture.mockedUserDto());
    }
}
