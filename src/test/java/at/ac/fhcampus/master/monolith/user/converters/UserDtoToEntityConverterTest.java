package at.ac.fhcampus.master.monolith.user.converters;

import at.ac.fhcampus.master.monolith.fixtures.UserFixture;
import at.ac.fhcampus.master.monolith.user.converters.UserDtoToEntityConverter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("test")
@SpringBootTest
class UserDtoToEntityConverterTest {

    @Test
    void convert() {
        UserDtoToEntityConverter converter = new UserDtoToEntityConverter();
        assertThat(converter.convert(UserFixture.mockedUserDto()))
                .isEqualToComparingFieldByField(UserFixture.mockedUser());
    }
}
