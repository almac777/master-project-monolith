package at.ac.fhcampus.master.monolith.user.converters;

import at.ac.fhcampus.master.monolith.fixtures.UserFixture;
import at.ac.fhcampus.master.monolith.user.converters.UserToDtoConverter;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@Import({
    UserToDtoConverter.class
})
class UserToDtoConverterTest {

    @Test
    void convert() {
        UserToDtoConverter userToDtoConverter = new UserToDtoConverter();
        assertThat(userToDtoConverter.convert(UserFixture.mockedUser()))
                .isEqualToComparingFieldByField(UserFixture.mockedUserDto());
    }
}
