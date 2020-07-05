package at.ac.fhcampus.master.monolith.user.services;

import at.ac.fhcampus.master.monolith.user.repositories.UserRepository;
import at.ac.fhcampus.master.monolith.fixtures.UserFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DefaultUserServiceTest {

    private DefaultUserService defaultUserService;
    private UserRepository mockedUserRepository;

    @BeforeEach
    void setup() {
        this.mockedUserRepository = mock(UserRepository.class);
        this.defaultUserService = new DefaultUserService(mockedUserRepository);
    }

    @Test
    void whenLoadUserByUsernameWithExistingUser_thenReturnUser() {
        when(this.mockedUserRepository.findByUsername("existing"))
                .thenReturn(UserFixture.optionalMockUser());
        assertThat(defaultUserService.loadUserByUsername("existing"))
                .isNotNull();
    }

    @Test
    void whenLoadUserByUsernameWithMissingUser_thenThrowException() {
        when(this.mockedUserRepository.findByUsername("inexisten"))
                .thenReturn(Optional.empty());
        assertThatExceptionOfType(UsernameNotFoundException.class)
                .isThrownBy(() -> defaultUserService.loadUserByUsername("inexistent"))
                .withMessageContaining("inexistent");
    }
}
